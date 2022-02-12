package random;

import java.util.Random;

public class random {
    public static void main(String[] args) {
        Random rnd = new Random();

        int upperBound = 100;

        rnd.nextDouble(); // [0, 1)
        rnd.nextInt(upperBound); // [0, upperBound)
        // IE381 / IE383
        // 60% Kadın 40% Erkek // [0, 6) -> Kadın, [6, 1) Erkek
        // [0, 4) Erkek, [4, 1) Kadın
        // 10, 5
        // 1000
        // Erkek
        // Kadın
        // Rastgelelik, zar atma, rastgele bir sayı seçme, ...
        // Olasılık hesaplamak (sthocastik bir şeyi deterministik yapmak)
    }
}
