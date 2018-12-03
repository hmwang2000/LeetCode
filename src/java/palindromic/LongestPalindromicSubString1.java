package java.palindromic;

/*
 * 两側比較法

以abba这样一个字符串为例来看，abba中，一共同拥有偶数个字。第1位=倒数第1位。第2位=倒数第2位......第N位=倒数第N位
以aba这样一个字符串为例来看，aba中。一共同拥有奇数个字符。排除掉正中间的那个字符后，第1位=倒数第1位......第N位=倒数第N位
所以，如果找到一个长度为len1的子串后，我们接下去測试它是否满足，第1位=倒数第1位。第2位=倒数第2位......第N位=倒数第N位。也就是说，去測试从头尾到中点，字符是否逐一相应相等。
*/
public class LongestPalindromicSubString1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome1("babcbabcbaccba"));
	}

	public static String longestPalindrome1(String s) {

		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();

		// check all possible sub strings
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}

		return longestPalindrome;
	}

	public static boolean isPalindrome(String s) {

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}
}
