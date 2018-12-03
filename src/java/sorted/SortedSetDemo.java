package java.sorted;

import java.util.*;

public class SortedSetDemo {
  public static void main(String[] args) {
    SortedSet<String> sortedSet = new TreeSet<String>();
    Collections.addAll(sortedSet,
      "one two three four five six seven eight"
        .split(" "));
    Print.print(sortedSet);
    String low = sortedSet.first();
    String high = sortedSet.last();
    Print.print(low);
    Print.print(high);
    Iterator<String> it = sortedSet.iterator();
    for(int i = 0; i <= 6; i++) {
      if(i == 3) low = it.next();
      if(i == 6) high = it.next();
      else it.next();
    }
    Print.print("low="+low);
    Print.print("high="+high);
    Print.print(sortedSet.subSet(low, high));
    Print.print(sortedSet.headSet(high));
    Print.print(sortedSet.tailSet(low));
    System.out.println(sortedSet.tailSet(low));
  }
} /* Output:
[eight, five, four, one, seven, six, three, two]
eight
two
one
two
[one, seven, six, three]
[eight, five, four, one, seven, six, three]
[one, seven, six, three, two]
*///:~
