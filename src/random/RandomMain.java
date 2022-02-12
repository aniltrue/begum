package random;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        MyRandom random = new MyRandom();

        System.out.println(random.roll());

        countHead(random);
    }

    public static void countHead(MyRandom random) {
        Random rnd = new Random(123);
        // H H T H
        for (int headCount = 0; headCount < 3; ) {
            int p = rnd.nextInt(2);

            if (p == 0) {
                headCount++;
                System.out.print("H ");
            } else {
                headCount = 0;
                System.out.print("T ");
            }
        }

        System.out.println(" Oldu");
    }
}
