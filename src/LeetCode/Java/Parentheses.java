/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
parentheses substring.
     For "(()", the longest valid parentheses substring is "()", which has length = 2.
     Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

package LeetCode.Java;

import java.util.Stack;

public class Parentheses {

    public int longestValidParentheses(String s) {
        // 用于记录待匹配的左括号和右括号的位置
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            // 如是当前字符是右括号，并且记录栈非空，并且前一个字符是左括号
            if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
                // 左括号出栈
                st.pop();
                // 求最大值
                max = Math.max(max, i - ((st.isEmpty()) ? -1 : st.peek()));
            }
            // 其它情况就将字符入栈
            else {
                st.push(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str = ")()())";
        Parentheses pt=new Parentheses();
        int max=pt.longestValidParentheses(str);
        System.out.print(max);
    }
}
