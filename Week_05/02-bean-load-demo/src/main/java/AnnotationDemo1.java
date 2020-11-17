import annotation.demo1.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemo1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("annotation.demo1");
        context.refresh();

//        ApplicationContext context = new AnnotationConfigApplicationContext("annotation.demo1");

        Dog dog = (Dog) context.getBean("gou");
        dog.say();

        Dog dog1 = context.getBean(Dog.class);
        dog1.say();


        if(dog==dog1){
            System.out.println("same dog");
        }
    }
}
