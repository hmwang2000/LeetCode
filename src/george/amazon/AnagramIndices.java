/**
 * 
 */
/**
 * @author Administrator
 *
 */
package george.amazon;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;  
import java.util.Comparator;  

public class AnagramIndices
{
    public List<Integer> getAnagramIndices(String haystack,String needle)
    {
    	List<Integer> listI=new ArrayList<Integer>();
    	
    	char[] needleCA = needle.toCharArray();
    	Arrays.sort(needleCA);
    	String sortedneedle=new String(needleCA);
    	    	
    	for(int i=0;i<haystack.length()-needle.length()+1;i++){
        	String substr=haystack.substring(i, i+needle.length());
    		char[] substrCA = substr.toCharArray();
    		Arrays.sort(substrCA);
        	String sortedsubstr=new String(substrCA);
        	
        	System.out.println(sortedsubstr);      
        	System.out.println("needle="+needle);      
        	if(sortedsubstr.equals(sortedneedle)){
            	listI.add(i);        		
        	}
        	
    	}

    	return listI;
    	
    }
    public static void main(String[] args)
    {
    	AnagramIndices solution=new AnagramIndices();
//    	List<Integer> listInt=new ArrayList<Integer>();
    	List<Integer> listInt;
    	
    	listInt=solution.getAnagramIndices("jdkKjdkjd", "jkd");

    	Collections.sort(listInt);
    	for(int i=0;i<listInt.size();i++){
    		System.out.println(listInt.get(i));
    	}

    }
    
}



