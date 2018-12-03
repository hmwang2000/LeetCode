package java.holding;

import java.util.*;  
import java.util.Map.Entry;  

public class Mapentry {    
   public static void main(String[] args) {     
       
	   Map<Integer,String> map = new HashMap<Integer,String>();     

       map.put(1, "January");
       map.put(2, "February");
       map.put(3, "March");
       map.put(4, "April");
       map.put(5, "May");
       map.put(6, "June");
       
       System.out.println("ForEach Iterate Map through entrySet:");   
       for( Entry<Integer,String> e : map.entrySet()) {
           System.out.println("key:"+e.getKey()+" value:"+e.getValue());  
       }     

       System.out.println("For Iterate Map through entrySet:");   
       for(Iterator<Entry<Integer,String>> i = map.entrySet().iterator(); i.hasNext(); ){
           Entry<Integer,String> e = i.next();
           System.out.println("key:"+e.getKey()+" value:"+e.getValue());  
       }  
         
         
 
       Iterator<Entry<Integer,String>> iterator = map.entrySet().iterator();
       System.out.println("While Iterate Map through entrySet:");   
       while(iterator.hasNext()) {  
           Entry<Integer,String> entry = iterator.next();
           Object key = entry.getKey();  
           Object value = entry.getValue();  
           System.out.println("key:"+key+" value:"+value);  
       }  
         
       Set<Integer> keySet= map.keySet();  
 
       Iterator<Integer> iteratorK = keySet.iterator();  
       System.out.println("While Iterate Map through keySet():");  
       while(iteratorK.hasNext()) {  
           Object key = iteratorK.next();  
           Object value = map.get(key);  
           System.out.println("key:"+key+" value:"+value);  
       }  

       System.out.println("ForEach Iterate Map through keySet():");  
       for(Integer key:keySet) {  
//           Object key = iteratorK.next();  
           Object value = map.get(key);  
           System.out.println("key:"+key+" value:"+value);  
       }  
       
       Collection<String> c = map.values();  
 
       Iterator<String> iteratorC = c.iterator();  
       System.out.println("While Iterate Map through values():");  
       while(iteratorC.hasNext()) {  
          Object value = iteratorC.next();   
          System.out.println("value:"+value);  
      }  
 
   }  
}  