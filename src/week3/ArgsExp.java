package week3;

public class ArgsExp {
    public static void main(String[] args) {
        int[] arr = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        // 3, 0, 1
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        if (arr.length % 2 == 1) {
            int index = arr.length / 2;

            // 12 21 34 44

            System.out.println(arr[index]);
        } else {
            int index1 = arr.length / 2;
            int index2 = index1 - 1;

            int median = (arr[index1] + arr[index2]) / 2;

            System.out.println(median);
        }
    }

    public static void findMedian(int[] arr) {
        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        // 3, 0, 1
        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[i]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }

        if (copy.length % 2 == 1) {
            int index = copy.length / 2;

            // 12 21 34 44

            System.out.println(copy[index]);
        } else {
            int index1 = copy.length / 2;
            int index2 = index1 - 1;

            int median = (copy[index1] + copy[index2]) / 2;

            System.out.println(median);
        }
    }
}
