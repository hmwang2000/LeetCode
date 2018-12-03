package java.reflect;

import java.lang.reflect.Field;

public class PrivateTest {     
    private String name = "hello";     
    public  long number ;

    public String getName() {     
        return name;     
    }    
    
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        PrivateTest pt = new PrivateTest();     
        
        Class<PrivateTest> clazz = PrivateTest.class;     
             
        Field field = clazz.getDeclaredField("name");     
        field.setAccessible(true);     
        field.set(pt, "world");     
        field.setAccessible(false);    
        
        Field fieldNum = clazz.getDeclaredField("number");     
        fieldNum.setAccessible(true);     
        fieldNum.set(pt, 20);     
        fieldNum.setAccessible(false);  
             
        System.out.println(pt.getName());
        System.out.println(pt.number);
    }
}