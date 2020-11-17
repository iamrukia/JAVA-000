import annotation.demo1.Dog;
import annotation.demo2.AnimalConfig;
import annotation.demo2.Cat;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemo2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);

        Dog dog = context.getBean(Dog.class);
        dog.say();


        try(Cat cat = context.getBean(Cat.class)) {
            cat.say();
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("No cat bean defined.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
