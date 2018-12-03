package george.amazon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ReaderWriter rw=new ReaderWriter();
		StringBuffer sb = new StringBuffer("This is a StringBuffer!"); 
		
		rw.readwriteFile();
		
		sb.append(" George Wang");
		System.out.println("StringBuffer sb="+sb);
		System.out.println("StringBuffer sbr="+sb.reverse());
		
		System.out.println("Done");

	}
	
	public void readwriteFile(){
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try{
			br=new BufferedReader(new FileReader("D:\\JavaUML\\StudyNotes.txt"));
			bw=new BufferedWriter(new FileWriter("D:\\javaUML\\Output.txt"));
			
			String str=null;
			
			while((str=br.readLine())!=null){
				bw.write(str,0,str.length());
				bw.newLine();
			}
		}catch (IOException e) {
            e.printStackTrace();
        }finally{
        	if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
}
