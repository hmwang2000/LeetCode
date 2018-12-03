package java.huawei;

import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.util.ArrayList;  
import java.util.Arrays;

/*
 *  最具夫妻像

规定男女名字中相同字母数最多的为“最具夫妻像”。举例来说，给出男生“li si”，在女生列表{“li li, wang fei, zhang man yu”}中匹配度最高的是“li li”。
假定所有人名都是由a~z的小写字母和空格组成，男生姓名从键盘输入，女生姓名已给出，当有多名女生符合要求时，按列表序输出第一个。

思路：由于女生列表已经给定，可以26位的字母建立Hash散列表，给出不同女生姓名的散列情况，同样地对于输入的男生姓名也可以求散列情况。然后求散列表匹配情况，取重合最多的输出。
 */
public class LikeCouple{
    public static void main(String[] args)throws Exception{
        //1.读取输入的boyname和girlsname
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String boyName = null;
        String girlsName = null;
        boyName = br.readLine();
        girlsName = br.readLine();
        //2.对boyname建立boyhashArray数组
        int[] boyhashArray = new int[26];
        Arrays.fill(boyhashArray,0);
        for(int i=0;i<boyName.length();i++){
            char c = boyName.charAt(i);
            int index = c - 'a';
            if(index >= 0 && index < 26)
                boyhashArray[index] = 1;
        }
        //3.将字符串girlsname分割为girl的数组
        String[] girlsNameArray = girlsName.split(",");
        //4.求解满足题意的name
        String likeCoupleName = likeCoupleFunc(girlsNameArray,boyhashArray);
        System.out.println(likeCoupleName);
    }
    public static String likeCoupleFunc(String[] names,int[] boyhashArray){
        int count = 0;
        String likeCoupleName = null;
        int n =0;
        String name = null;
        String[] namess = names;
        int[] boyhashArrays = boyhashArray;
        int[] hashArray = new int[26];


        Arrays.fill(hashArray,0);
        //5.循环girlsname数组的每一个girlname
        for(int i =0;i<namess.length;i++){
            name = namess[i];
            for(int j=0;j<name.length();j++){
                char c = name.charAt(j);
                int index = c - 'a';
                if(index >= 0 && index < 26)
                    hashArray[index] = 1;
            }
            for(int hp:hashArray){
                System.out.print(hp+"");
            }
            System.out.println();
            n = 0;
            //6.比较boyname和girlname，求相同的个数
            for(int k =0 ;k<hashArray.length;k++){
                if(hashArray[k]==1 && boyhashArrays[k] ==1){
                    n++;
                }
            }
            //7求出最大的个数，以及其name
            if(n > count){
                count = n;
                likeCoupleName = name;
            }
            Arrays.fill(hashArray,0);
        }
        return likeCoupleName;
    }
}  