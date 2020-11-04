package demo;

public class CheckSize {
    public static void main(String[] args) {
        int[] ints = new int[256];
        int[][] ints1 = new int[128][2];

//        for (int i = 0; i < 128; i++) {
//            ints1[i][0] = i;
//            ints1[i][1] = i + 128;
//        }
        System.out.println(InstrumentationAgent.getObjectSize(ints));
        System.out.println("===");
        System.out.println(InstrumentationAgent.getObjectSize(ints1));

        final int x = 0;
        
    }
}
