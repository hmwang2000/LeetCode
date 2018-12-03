package george.amazon;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;  

public class ConcurrentHashMapTest {  
      
    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();  
    public static void main(String[] args) throws InterruptedException {  
        new Thread("Thread1"){  
            @Override  
            public void run() {  
                map.put(3, 33);
                System.out.println("Thread 1:" + map);
            }  
        }.start();  
          
        new Thread("Thread2"){  
            @Override  
            public void run() {  
                map.put(4, 44);  
                System.out.println("Thread 2:" + map);
            }  
        }.start();  
          
        new Thread("Thread3"){  
            @Override  
            public void run() {  
                map.put(7, 77);
                System.out.println("Thread 3:" + map);
            }  
        }.start();
        Thread.sleep(3000);
		Iterator<Integer> ite = map.keySet().iterator();
	  	while(ite.hasNext()){
	  		Integer key = ite.next();
	  		System.out.println(key+" : " + map.get(key));        
//            System.out.println("Thread Main:" + map);  
        }
    }
}  