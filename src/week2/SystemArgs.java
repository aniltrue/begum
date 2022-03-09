package week2;

public class SystemArgs {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Hatalı giriş!");
            return;
        }
        // Double.parseDouble()
        int maxVal1 = Integer.parseInt(args[0]);
        int maxVal2 = Integer.parseInt(args[1]);
        int sum = maxVal1 + maxVal2;

        if (maxVal2 > maxVal1) {
            maxVal1 = Integer.parseInt(args[1]);
            maxVal2 = Integer.parseInt(args[0]);
        }

        // 3 6 1
        // 1: 3
        // 2: 6
        // v: 1
        for (int i = 2; i < args.length; i++) {
            int value = Integer.parseInt(args[i]);
            sum += value;

            if (value > maxVal1) {
                maxVal2 = maxVal1;
                maxVal1 = value;
            } else if (value > maxVal2) {
                maxVal2 = value;
            }
        }

        System.out.println(sum + " - " + maxVal1 + " - " + maxVal2);
    }
}
