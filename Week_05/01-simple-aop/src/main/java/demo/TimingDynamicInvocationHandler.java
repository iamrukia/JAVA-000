package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TimingDynamicInvocationHandler implements InvocationHandler {

    private final Map<String, Method> methodMap = new HashMap<>();
    private Object object;

    public TimingDynamicInvocationHandler(Object object) {
        this.object = object;

        for(Method method: object.getClass().getDeclaredMethods()){
            methodMap.put(method.getName(),method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long start = before(method);
        Object result = methodMap.get(method.getName()).invoke(object,args);
        long elapsed = after(method) - start;
        System.out.println("Executing " + method.getName() + " finished in " + elapsed + " nano seconds.");
        return result;
    }

    private long before(Method method) {
        System.out.println("===system time before invoke method " + method.getName());
        long start = System.nanoTime();
        System.out.println(start);
        return start;
    }

    private long after(Method method) {
        System.out.println("===system time before invoke method " + method.getName());
        long after = System.nanoTime();
        System.out.println(after);
        return after;
    }


}
