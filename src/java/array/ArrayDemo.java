package java.array;

import java.util.List;
import java.util.ArrayList;
//import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args){
		int size=5;
		double[] myArray = new double[size];		
		myArray[0]=5.6;
		myArray[1]=6.6;
		myArray[2]=7.6;
		myArray[3]=8.6;
		myArray[4]=9.6;
		int length = myArray.length;
		
		for(double db:myArray){
			System.out.println(db);
		}
		
		List<String> myList = new ArrayList<String>();
		myList.add("abc");
		myList.add("bcd");
		myList.add("dce");
		myList.add("efg");
		myList.add("fgh");
		int len = myList.size();
		
		String[] myStr = (String[])myList.toArray(new String[size]);
		
		for(String str:myStr){
			System.out.println(str);
		}
		
		myList.forEach(item->{
			if(item.equals("fgh")){ System.out.println("$$$$$$$$$$"+item);}
		});
		
		myList.stream().filter(s->s.contains("fg")).forEach(System.out::println);
	}	
}
