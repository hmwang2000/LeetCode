package java.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
	public static void main(String args[]) throws InterruptedException {
		Map<Integer,Integer> numberAndCount = new HashMap<Integer,Integer>();
		Integer[] numbersINT = {3, 5, 7,9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};
		System.out.println("----");

		Integer count = (Integer)numberAndCount.get(3);
		if(count == null){
			System.out.println("0");
		}

		for(Integer i : numbersINT){
//			for(int k=0; k<10; k++){
				count = (Integer)numberAndCount.get(i);
				if(count == null){
//					System.out.println("0");
					count=0;
				}
				count++;
				numberAndCount.put(i, count); // NullPointerException
				System.out.println(i+" occurs "+count);
		}
		
		for(Integer i : numbersINT){
			count = (Integer) numberAndCount.get(i);
			numberAndCount.put(i, count++); // NullPointerException
		}

	}
}
