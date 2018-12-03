package java.palindromic;

import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.IOException;

/*
 * 回文数字猜想

给出一个数字N，如68，定义它的逆数为86，那么经过68+86=154，154+451=605，605+506=1111这样几次操作后，
可以得到回文数字1111。现在需要判断经过7次操作是否可以得到回文，如果能，输出回文，如果不能输出0。

思路：拆分各个位数并逆序相加，对和数判断回文。

（数字与逆序相加，如果对应位置相加不产生进位，那么结果肯定是回文；产生进位的有可能是回文，如605+506）
 */
public class Palindrome{
    public static void main(String[] args)throws Exception{
        //1.得到输入的数字；
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        //2.判断数字是否满足题意，满足输出数值否则输出0；
        if(isRight(str)){
            System.out.println(str);
        }else{
            System.out.println("0");
        }
    }
    public static boolean isRight(String str){
        String s = str;
        long value = Long.parseLong(s);
        //3.得到数值逆数
        long sum = ReverseFunc(value);
        //4.在7次计算中，满足则返回true
        for(int i=0;i<7;i++){
            sum += value;
            long sumR = ReverseFunc(sum);
            if(sumR == sum ){
                return true;
            }
            value = sumR;
        }
        return false;
    }
    //5.利用StringBuffer的reverse来计算数值的逆数
    public static long ReverseFunc(long sum){
        //5利用StringBuffer的reverse来计算数值的逆数
        String s = String.valueOf(sum);
        StringBuffer sb = new StringBuffer(s);
        StringBuffer sbReverse = sb.reverse();
        String strReverse = new String(sbReverse);
        long value = Long.parseLong(strReverse);
        return value;
    }
}