package DesignPattern.creation.singleton;

public class InnerClassSingleton{  
    private static class SingletonHolder{  
        public static InnerClassSingleton instance = new InnerClassSingleton();  
    }  
    private InnerClassSingleton(){}  
    public static InnerClassSingleton newInstance(){  
        return SingletonHolder.instance;  
    }  
}  