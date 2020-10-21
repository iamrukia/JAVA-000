package demo;

import java.util.ArrayList;
import java.util.List;

public class GCDemo {
    public static void main(String[] args) throws InterruptedException {
        GCDemo gcDemo = new GCDemo();
        List<String> stringList = new ArrayList<>();
        int i = 0;
        List<String> stringList2 = new ArrayList<>();
        while(true){
            String temp = gcDemo.sum_loop();

            if(i%10000==0) {
                Thread.sleep(500);
                stringList.clear();
                stringList2.add(gcDemo.sum_loop()+"x");

            }

            if(i%10000000==0){
                stringList2.clear();

            }
            stringList.add(gcDemo.sum_loop());

            i = i+1;
        }
    }

    String sum_loop() {

        Integer x = 10;
        for (Integer i = 0; i < 100; i = i + 1) {
            x = x + i;
        }
        return x.toString();
    }


}
