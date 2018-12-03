package java.list;

class Parent {
    public Parent(){
        System.out.println("A");
    }

	public Parent(String s){
        System.out.println("B");
    }
}
public class Son extends Parent{
    public Son(String s){
//    	super("X");
        System.out.println("D");
    }
    
    public static void main(String args[]){
        new Son("");
        System.out.println("C");
    }
}