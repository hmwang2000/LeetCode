package java.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

public class ObjectStreamTest {
	 public static void main(String[] args) throws ParseException {
		  // TODO Auto-generated method stub
		  User user = new User("Heather",14);
		  user.setName("George");
		  try {
			   ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream("D:\\JavaUML\\object.txt"));
			   out.writeObject(user);
			   out.close();
			   
			   ObjectInputStream  in = new ObjectInputStream(new FileInputStream("D:\\JavaUML\\object.txt"));
			   User user1 = (User)in.readObject();
//			   System.out.println(user1.getName());
			   System.out.println(user1);
		  } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		       e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		       e.printStackTrace();
		  }catch (ClassNotFoundException e) {
		   // TODO Auto-generated catch block
		       e.printStackTrace();
		  }
		 }
}


class User implements java.io.Serializable{
	
	 private String name;
	 private int age; 
	 
	 public User(String name, int age) {  
	        super();  
	        this.name = name;  
	        this.age = age;  
	 }  	 

	 /**
	  * @return the name
	  */
	 public String getName() {
	     return name;
	 }

	 /**
	  * @param name the name to set
	  */
	 public void setName(String name) {
	     this.name = name;
	 }

	 /**
	  * @param age the age to set
	  */
	 public void setAge(int age) {
	     this.age = age;
	 }

	 /**
	  * @return the age
	  */
	 public int getAge() {
	     return age;
	 }

	 @Override  
	 public String toString() {  
	       return "User [name=" + name + ", age=" + age + "]";  
	 }  

}
