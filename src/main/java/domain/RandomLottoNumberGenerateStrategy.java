package domain;

import java.util.Enumeration;
import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomLottoNumberGenerateStrategy {
    private static Random random = new Random();

    private static int max = 45;
    private static int min = 1;


    public static int nextInt(){
        return min + random.nextInt(max - min + 1);
    }


}
