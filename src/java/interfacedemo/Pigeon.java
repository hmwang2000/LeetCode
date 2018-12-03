package java.interfacedemo;

public class Pigeon extends Bird implements Flyanimal {
    @Override
    public void fly(){
        System.out.println("Pigeon can fly");
    }
    public void egg(){
        System.out.println("Pigeon can lay eggs");
    }
}