package annotation.demo2;

public class Cat implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("..................cat closed");
    }

    public void say(){
        System.out.println("============Miao!");
    }
}
