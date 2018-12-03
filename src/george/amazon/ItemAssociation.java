package george.amazon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.List;


/* Input
 * ItemAssociation:
[[Item1,Item2]
[Item3,Item4]
[Item4,Item5]
[Item6,Item7]]
*/
/* Input
 * ItemAssociation:
[[Item1,Item2]
[Item3,Item4]
[Item4,Item5]
[Item4,Item8]
[Item6,Item7]
[Item7,Item9,Item10,Item11]]
 */

public class ItemAssociation {

    public static void main(String[] args) throws IOException{
    	
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new FileWriter("abx.txt"));

    	String str = null;
    	String strT1 = null;
    	String strT2 = null;
    	String strT3 = null;
    	List<Set<String>> arraySet = new ArrayList<Set<String>>();

//		System.out.println("Please input your ItemAssociation:");

    	while((str=br.readLine()) != null){
    		strT1=str.replaceAll("\\[", "");
    		strT2=strT1.replaceAll("]", "");
    		strT3=strT2.trim();
//    		System.out.println(strT3);
    		Set<String> hs1=new HashSet<String>();
    		Set<String> hs2=new TreeSet<String>();

        	String[] items=strT3.split(",");
        	for(String s:items){
        		hs2.add(s);
        	}
        	if(arraySet.size()==0){ 
        		arraySet.add(hs2);
        	}else
        	{
        		int num=0;
        		for(int i=0; i<arraySet.size();i++){
        			Set<String> temp1 = new HashSet<>();
        			Set<String> temp2 = new TreeSet<>();
        			temp2.addAll(arraySet.get(i));
        			temp2.retainAll(hs2);
        			if(temp2.isEmpty()){
        				num++;
        			}else{
        				temp2.clear();
        				temp2.addAll(arraySet.get(i));
        				temp2.addAll(hs2);
        				arraySet.set(i, temp2);
        				break;
        			}
        		}
        		if(num==arraySet.size()){
    				arraySet.add(hs2);
        		}
        	}
//        	System.out.println(arraySet.size());
    		if (str.endsWith("]]")) break;
    	}

    	br.close();
    	bw.close();
    	System.out.println(arraySet);
		System.out.println("----------------------------------------");
    	for(Set<?> al:arraySet){
    		System.out.println(al);
    	}
		System.out.println("----------------------------------------");
		int max=arraySet.get(0).size();
		int idx=0;
		for(int i=1; i<arraySet.size();i++){
			if(max<arraySet.get(i).size()){
				max=arraySet.get(i).size();
				idx=i;
			}
			
		}
    	if(idx>=0){
    		System.out.println(arraySet.get(idx));
    	}
    	
    	if(1==1) return;
    	
        Set<Integer> result = new HashSet<Integer>();
        @SuppressWarnings("serial")
		Set<Integer> set1 = new HashSet<Integer>(){{
            add(1);
            add(3);
            add(5);
        }};

        @SuppressWarnings("serial")
		Set<Integer> set2 = new HashSet<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("Insection: "+result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("Difference: "+result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("Union: "+result);
        
    }

}
