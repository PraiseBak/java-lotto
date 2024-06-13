package util;

public class LottoInputValidUtil {

    private static int divideUnit = 1000;

    public static boolean isIntegerStr(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }

    public static boolean isNatural(int num) {
        return num > 0;
    }

    public static boolean isDividedByUnit(int num){
        return (num % divideUnit == 0);
    }

}

