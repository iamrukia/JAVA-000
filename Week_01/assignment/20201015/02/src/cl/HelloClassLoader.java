package cl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        HelloClassLoader helloClassLoader = new HelloClassLoader();
        Class<?> hello = helloClassLoader.findClass("Hello.xlass");
        Object obj = hello.newInstance();
        hello.getMethod("hello").invoke(obj);

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bytes = new byte[0];
        String filePath = System.getProperty("user.dir") + "/resources/" + name;
        try {
            bytes = loadClassBytes(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] convertedBytes = convertBytes(bytes);
        return defineClass("Hello", convertedBytes, 0, convertedBytes.length);

    }

    //读取原始文件字节
    private byte[] loadClassBytes(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllBytes(path);
    }

    //字节转换
    private byte[] convertBytes(byte[] bytes) {
        byte[] convertedBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            convertedBytes[i] = (byte) (255 - bytes[i]);
        }
        return convertedBytes;
    }
}
