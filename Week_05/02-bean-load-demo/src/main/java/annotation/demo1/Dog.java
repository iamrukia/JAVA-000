package annotation.demo1;

import org.springframework.stereotype.Component;

@Component("gou")
public class Dog {
    public void say(){
        System.out.println("======Wang!");
    }
}
