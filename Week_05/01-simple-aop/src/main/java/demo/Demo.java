package demo;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        ICar carProxyInstance = (ICar) Proxy.newProxyInstance(
                Demo.class.getClassLoader(),
                new Class[]{ICar.class},
                new TimingDynamicInvocationHandler(new Car())
        );

        carProxyInstance.run();
    }
}
