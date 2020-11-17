import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.Duck;

public class XmlDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("duckBean.xml");
        Duck duck = (Duck) context.getBean("duck");
        duck.say();

    }
}
