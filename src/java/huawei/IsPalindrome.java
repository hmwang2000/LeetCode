package java.huawei;

public class IsPalindrome {
    public static void main(String[] args)throws Exception{  

    	String str = "abccbba";

    	if(validPalindrome(str)){
    		System.out.println(str+" TRUE");
    	}else{
    		System.out.println(str+" FALSE");    		
    	}
    }  
    public static boolean isPalindromeRange(String s, int i, int j) {
    	if(i>j) return false;
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
    	for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;
            if (s.charAt(i) != s.charAt(j)) {
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }
}
