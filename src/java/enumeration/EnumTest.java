package java.enumeration;

public class EnumTest {
    public enum Hello{  
        Jenny("Jenny"),  
        Tom("Tom"),  
        Antia("Antia"),  
        Crite("Crite");  
        private String name;  
          
        Hello(String name){  
              
            this.name = name;  
        }  
  
        public String getName() {  
            return name;  
        }  
  
        public void setName(String name) {  
            this.name = name;  
        }  
    }  
      
    public static void main(String[] args) {  
        Hello.Crite.setName("good");  
        String hello = Hello.Crite.name;  
        System.out.println(hello);  
        String name = Hello.Antia.name;  
        System.out.println(name);  
    }  
}
