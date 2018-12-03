package java.huawei;

import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.util.ArrayList;

/*
 * 计算最后一个出列者的编号
描述: 现在有n个竞争者围坐一圈，争夺一个很有吸引力的工作（年薪100w $）。假设这些人编号1，2，。。。，n。第一次从1开始报数，数到m（m>0）的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列。以此类推，直到所有人出列为止。老板说最后一个出列的人将获得这份工作。

如果你也想竞争这份工作，那么你会坐着哪个位置上？

实现一个函数，当老板告诉你n和m时，返回得到工作的那个人的编号。

运行时间限制: 无限制
内存限制: 无限制
输入: 竞争者人数,报数

输出: 最后出列的竞争者的编号。异常则返回 -1。

样例输入: 10,10
样例输出: 8

答案提示:

思路：这明显是个约瑟夫问题。（1）常规的解法是：建立一个有N个元素的循环链表，然后从链表头开始遍历并记数，如果计数i==m(i初始为1)踢出元素，继续循环，当当前元素与下一元素相同时退出循环。（2）归纳为数学性解法：此方法最要是数学方法。不仅可以让编程变得简单，而且往往会成倍地提高算法执行效率。（3）下面代码用的是：建立一个顺序表，循环删除到报数的，每次删除后，都讲整个表重新排序。直到最后一个人。
 */
public class JosephRing{
    public static void main(String[] args)throws Exception{
        //1读取竞争者人数，以及报数
        InputStreamReader irs = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(irs);
        String mString = br.readLine();
        String nString = br.readLine();
        //2设置一个标志位，表示输入数据是否符合题意
        boolean flag = false;
        //3检查的数据是否以0开头
        if(mString.charAt(0) == '0' || nString.charAt(0) == '0'){
            flag = true;
        }
        //4检查两个数据字符串是否只含数字
        for(int mi =0;mi< mString.length();mi++){
            char c = mString.charAt(mi);
            if(c < '0' || c > '9' ){
                flag = true;
            }
        }
        for(int ni =0;ni< nString.length();ni++){
            char c = nString.charAt(ni);
            if(c < '0' || c > '9' ){
                flag = true;
            }
        }
        //5不满足题意，则输出-1并结束
        if(flag){
            System.out.println("-1");
            System.exit(0);
        }
        //6字符串转为数值，
        int m = Integer.parseInt(mString);
        int n = Integer.parseInt(nString);
        //7两个数值都应该大于0
        if( n < 0 || m < 0){
            System.out.println("-1");
            System.exit(0);
        }
        //8一个ArrayList装竞争人
        ArrayList<Integer> IntArray = new ArrayList<Integer>();

        for(int i =0;i< m;i++){
            IntArray.add(i+1);
        }
        //9循环淘汰竞争人，直到最后一个
        while(IntArray.size() != 1){
            int  mod = n % IntArray.size();
            if(mod == 0){
                //10淘汰最后一个人
                IntArray.remove(IntArray.size()-1);
            }else{
                //11淘汰非最后一个人，然后被淘汰人前面的人后移到最后面
                IntArray.remove(mod - 1);
                for(int i=0;i< mod-1;i++){
                    int value = IntArray.remove(0);
                    IntArray.add(value);
                }
            }
        }
        System.out.println(IntArray.get(0)+"");
    }
}  