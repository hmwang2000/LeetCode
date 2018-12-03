package java.interfacedemo;

public class Ant extends Insect implements Flyanimal {
    @Override
    public void fly(){
        System.out.println("Ant can fly");
    }
}