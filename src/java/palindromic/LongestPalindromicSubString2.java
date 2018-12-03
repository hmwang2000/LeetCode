package java.palindromic;

/*
 * 动态规划法

如果dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么能够推出：
    dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
    这是一般的情况，因为须要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，因此须要求出基准情况才干套用以上的公式：
    a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
    b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
    有了以上分析就能够写出代码了。

须要注意的是动态规划须要额外的O(n2)的空间。
*/
public class LongestPalindromicSubString2 {

	public static String longestPalindrome2(String s) {
		if (s == null)
			return null;

		if(s.length() <=1)
			return s;

		int maxLen = 0;
		String longestStr = null;

		int length = s.length();

		int[][] table = new int[length][length];

		//every single letter is palindrome
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		printTable(table);

		//e.g. bcba
		//two consecutive same letters are palindrome
		for (int i = 0; i <= length - 2; i++) {
			//System.out.println("i="+i+"  "+s.charAt(i));
			//System.out.println("i="+i+"  "+s.charAt(i+1));
			if (s.charAt(i) == s.charAt(i + 1)){
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
			}
		}
		System.out.println(longestStr);
		printTable(table);
		//condition for calculate whole table
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i <= length-l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maxLen)
						longestStr = s.substring(i, j + 1);

				} else {
					table[i][j] = 0;
				}
				printTable(table);
			}
		}

		return longestStr;
	}
	public static void printTable(int[][] x){
		for(int [] y : x){
			for(int z: y){
				//System.out.print(z + " ");
			}
			//System.out.println();
		}
		//System.out.println("------");
	}
	public static void main(String[] args) {
		System.out.println(longestPalindrome2("1263625"));//babcbabcbaccba
	}
}