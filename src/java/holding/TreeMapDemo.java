package java.holding;

import java.util.*;

public class TreeMapDemo{
	public static void main(String[] args) {
		System.out.println("Tree Map Example!\n");
		TreeMap <String, List<String>> gMap = new TreeMap<String, List<String>>();
		TreeMap <String, SortedSet<String>> aMap = new TreeMap<String, SortedSet<String>>();
    	String itemgrp1="item4,item3";
    	String itemgrp2="item2,item1,item3";
    	String itemgrp3="item6,item5";
    	String itemgrp4="item7";
    	String[] itemarray1=itemgrp1.split(",");
    	String[] itemarray2=itemgrp2.split(",");
    	String[] itemarray3=itemgrp3.split(",");
    	String[] itemarray4=itemgrp4.split(",");
    	List<String> itemlist1=Arrays.asList(itemarray1);
    	List<String> itemlist2=Arrays.asList(itemarray2);
    	List<String> itemlist3=Arrays.asList(itemarray3);
    	List<String> itemlist4=Arrays.asList(itemarray4);

		gMap.put(itemlist1.get(0), itemlist1);
		gMap.put(itemlist2.get(0), itemlist2);
		gMap.put(itemlist3.get(0), itemlist3);
		gMap.put(itemlist4.get(0), itemlist4);

		//Rerieving all keys
		System.out.println("Keys of tree gMap: " + gMap.keySet());
		
		//Rerieving all values
		System.out.println("Values of tree gMap: " + gMap.values()+"\n");
		
		SortedSet<String> itemset1 = new TreeSet<String>();
    	SortedSet<String> itemset2 = new TreeSet<String>();
    	SortedSet<String> itemset3 = new TreeSet<String>();
    	SortedSet<String> itemset4 = new TreeSet<String>();

    	Collections.addAll(itemset1,itemarray1);
    	Collections.addAll(itemset2,itemarray2);
    	Collections.addAll(itemset3,itemarray3);
    	Collections.addAll(itemset4,itemarray4);

		aMap.put(itemset1.first(), itemset1);
		aMap.put(itemset2.first(), itemset2);
		aMap.put(itemset3.first(), itemset3);
		aMap.put(itemset4.first(), itemset4);

		//Rerieving all keys
		System.out.println("Keys of tree aMap: " + aMap.keySet());
		
		//Rerieving all values
		System.out.println("Values of tree aMap: " + aMap.values()+"\n");
		
		
//		SortedSet<String> retainSet=itemset2;
		SortedSet<String> retainSet=new TreeSet<String>();
		
		retainSet.addAll(itemset1);
		retainSet.retainAll(itemset2);
		System.out.println("RetainSet of Set1 and Set2: " + retainSet);
		System.out.println("Set1: " + itemset1);
		System.out.println("Set2: " + itemset2+"\n");

		SortedSet<String> diffSet = new TreeSet<String>();
		
		diffSet.addAll(itemset1);
		retainSet.removeAll(itemset2);
		System.out.println("DiffSet of Set1 and Set2: " + diffSet);
		System.out.println("Set1: " + itemset1);
		System.out.println("Set2: " + itemset2+"\n");
		
		SortedSet<String> unionSet = new TreeSet<String>();
		
		unionSet.addAll(itemset1);
		unionSet.addAll(itemset2);
		System.out.println("DiffSet of Set1 and Set2: " + unionSet);
		System.out.println("Set1: " + itemset1);
		System.out.println("Set2: " + itemset2+"\n");
		

		TreeMap <Integer, String>tMap = new TreeMap<Integer, String>();

		//Addding data to a tree map
		tMap.put(6, "Friday");
		tMap.put(7, "Saturday");
		tMap.put(4, "Wednesday");
		tMap.put(5, "Thursday");
		tMap.put(1, "Sunday");
		tMap.put(2, "Monday");
		tMap.put(3, "Tuesday");
		
		//Rerieving all keys
		System.out.println("Keys of tree map: " + tMap.keySet());
		
		//Rerieving all values
		System.out.println("Values of tree map: " + tMap.values()+"\n");
		
		//Rerieving the value from key with key number 5
		System.out.println("Key: 5 value: " + tMap.get(5)+ "\n");

		//Rerieving the First key and its value
		System.out.println("First key: " + tMap.firstKey() + " Value: " + tMap.get(tMap.firstKey()) + "\n");
		
		//Rerieving the Last key and value
		System.out.println("Last key: " + tMap.lastKey() + " Value: " + tMap.get(tMap.lastKey()) + "\n");
		
		//Removing the first key and value
		System.out.println("Removing first data: " + tMap.remove(tMap.firstKey()));
		System.out.println("Now the tree map Keys: " + tMap.keySet());
		System.out.println("Now the tree map contain: " + tMap.values() + "\n");
		
		//Removing the last key and value
		System.out.println("Removing last data: " + tMap.remove(tMap.lastKey()));
		System.out.println("Now the tree map Keys: " + tMap.keySet());
		System.out.println("Now the tree map contain: " + tMap.values());
	}
}