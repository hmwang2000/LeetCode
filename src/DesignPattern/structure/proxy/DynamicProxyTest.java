package DesignPattern.structure.proxy;

/**
 * @description 代理模式 之 JDK的动态代理
 * @description 测试类DynamicProxyTest
 * @description 动态代理指的是，在程序运行时，运用反射机制动态生成源代码，再对其进行编译。
 * @description JDK的动态代理组成要素:
 * 1,一个接口
 * 2，一个接口实现类
 * 3，一个代理类，实现了InvocationHandler接口
 */
public class DynamicProxyTest {
    public static void main(String[] args){
        DynamicProxy dynamicProxy = new DynamicProxy();
        DynamicProxyInterface dynamicProxyForImpl = (DynamicProxyInterface) dynamicProxy.dynamicBindImplToProxyClass(new DynamicProxyImpl());
        dynamicProxyForImpl.queryInfo();
    }
    /*
     *    JDK的动态代理依靠具体的接口，如果有些类并没有实现，则不能使用JDK的动态代理，这时候就需要
     * 使用CGLIB的动态代理
     * // JDK的动态代理的关键是InvocationHandler接口
     */
}  