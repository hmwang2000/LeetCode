package java.stream;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;  
import java.util.ArrayList;  
import java.util.List;  
  
public class Serializable {  
  
    private static List<String> list = new ArrayList<String>();  
    private static File file = new File("D:/temp/Userbase.txt");  
      
    public static void main(String[] args) {  
        for(int i=1; i<=5; i++){  
            list.add("ID:2017090"+i+" USERNAME:George"+i+" AGE: "+i);  
        }  
        serializable();  
        turnSerializable();  
    }  
      
    public static void serializable(){  
        try {  
            FileOutputStream fos = new FileOutputStream(file);  
            ObjectOutputStream oos = new ObjectOutputStream(fos);  
            oos.writeObject(list);  
            oos.flush();   
            fos.close();   
            oos.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    @SuppressWarnings("unchecked")  
    public static void turnSerializable(){  
        try {  
            FileInputStream fis = new FileInputStream(file);  
            ObjectInputStream ois = new ObjectInputStream(fis);  
            list = (List<String>) ois.readObject();  
            System.out.println("Total "+list.size()+" Users: ");  
            for(String s : list){  
                System.out.println(s);  
            }  
            fis.close();  
            ois.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
