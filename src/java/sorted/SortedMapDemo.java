package java.sorted;

import java.util.*;

public class SortedMapDemo {
	  public static void main(String[] args) {
	    TreeMap<Integer,String> sortedMap =
	      new TreeMap<Integer,String>(new CountingMapData(10));
	    Print.print(sortedMap);
	    Integer low = sortedMap.firstKey();
	    Integer high = sortedMap.lastKey();
	    Print.print(low);
	    Print.print(high);
	    Iterator<Integer> it = sortedMap.keySet().iterator();
	    for(int i = 0; i <= 6; i++) {
	      if(i == 3) low = it.next();
	      if(i == 6) high = it.next();
	      else it.next();
	    }
	    Print.print(low);
	    Print.print(high);
	    Print.print(sortedMap.subMap(low, high));
	    Print.print(sortedMap.headMap(high));
	    Print.print(sortedMap.tailMap(low));
	  }
	} /* Output:
	{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
	0
	9
	3
	7
	{3=D0, 4=E0, 5=F0, 6=G0}
	{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0}
	{3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
	*///:~