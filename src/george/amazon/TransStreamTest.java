package george.amazon;

import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.io.OutputStreamWriter;

public class TransStreamTest {

    /**
     * 主要的类：    in1,    InputStream
     *                      创建对象 InputStream in = System.in;
     *              in2,    InputStreamReader  没有readLine()方法
     *                      主要方法：
     *                          read()读取单个字符，一个汉字也为一个字符。
     *                          read(char[] cbuf)将字符读入数组。
     *                          close().关闭此流和相关联资源。
     *              in3,    BufferedReader     有read(),readLine()方法。
     *              out1,   OutputStream
     *                      创建对象 OutputStream in = System.out;
     *              out2,   OutputStreamWriter
     *                      主要方法：
     *                          write(int c)//写入单个字符。
     *                          write(char[] cbuf,int off,int len)//写入数组的某一部分
     *                          write(String str,int off,int len)//写入字符串烦人某一部分。
     *                          flush();//刷新该流中的缓冲。
     *                          close();
     *              out3,   BufferedWriteer     有Write(int ch),newLine()方法。
     *
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//     transReadByBuf();
//     transReadNoBuf();
//       transWriteNoBuf();
        transWriteByBuf();

    }

    public static void transWriteNoBuf() throws IOException {
        OutputStream out = System.out;//打印到控制台
//     OutputStream out = new FileOutputStream("D:\\JavaUML\\demo.txt");//打印到文件
        OutputStreamWriter osr = new OutputStreamWriter(out);//输出
//     OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("D:\\JavaUML\\demo.txt"));//两句可以综合到一句。
//     int ch = 97;//a
//     int ch = 20320;//你
//     osr.write(ch);
        String str = "How are you?";
        osr.write(str);
        osr.flush();
        osr.close();
    }
    public static void transWriteByBuf() throws IOException {
//         OutputStream out = System.out;//打印到控制台。
        OutputStream out = new FileOutputStream("D:\\JavaUML\\demo.txt");//打印到文件。
        OutputStreamWriter osr = new OutputStreamWriter(out);//输出
//         OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("D:\\JavaUML\\demo.txt"));//综合到一句。
        BufferedWriter bufw = new BufferedWriter(osr);//缓冲
//     int ch = 97;//a
//     int ch = 20320;//你
//     osr.write(ch);
        String str = "How are you? I am fine.";
        bufw.write(str);
        bufw.flush();
        bufw.close();
    }


    public static void transReadNoBuf() throws IOException {
        /**
         * 没有缓冲区，只能使用read()方法。
         */
        //读取字节流
//     InputStream in = System.in;//读取键盘的输入。
        InputStream in = new FileInputStream("D:\\JavaUML\\demo.txt");//读取文件的数据。
        //将字节流向字符流的转换。要启用从字节到字符的有效转换，可以提前从底层流读取更多的字节.
        InputStreamReader isr = new InputStreamReader(in);//读取
//     InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\JavaUML\\demo.txt"));//综合到一句。

        char []cha = new char[1024];
        int len = isr.read(cha);
        System.out.println(new String(cha,0,len));
        isr.close();
    }

    public static void transReadByBuf() throws IOException {
        /**
         * 使用缓冲区 可以使用缓冲区对象的 read() 和  readLine()方法。
         */
        //读取字节流
//     InputStream in = System.in;//读取键盘上的数据
        InputStream in = new FileInputStream("D:\\JavaUML\\demo.txt");//读取文件上的数据。
        //将字节流向字符流的转换。
        InputStreamReader isr = new InputStreamReader(in);//读取
        //创建字符流缓冲区
        BufferedReader bufr = new BufferedReader(isr);//缓冲
//     BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\JavaUML\\demo.txt")));//综合到一句。
   /*  int ch =0; 
       ch = bufr.read(); 
       System.out.println((char)ch);*/
        String line = null;
        while((line = bufr.readLine())!=null){
            System.out.println(line);
        }
        isr.close();
    }
}  