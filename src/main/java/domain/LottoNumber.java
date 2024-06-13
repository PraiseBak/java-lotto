package domain;

import helper.LottoErrorEnum;

import java.util.HashSet;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    public boolean isBonus() {
        return isBonus;
    }

    private boolean isBonus = false;

    @Override
    public String toString() {
        return "LottoNumber{" +
                ", num=" + num +
                '}';
    }

    int min = 1;
    int max = 45;

    HashSet<Integer> inputHashSet = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    int num;

    public LottoNumber(int num,boolean isBonus){
        this.num = num;
        this.isBonus = isBonus;
        inputHashSet.add(num);
    }

    public static LottoNumber createRegularNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(LottoErrorEnum.InvalidLottoNum.getText());
        }

        return new LottoNumber(num, false);
    }

    public static LottoNumber createBonusNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(LottoErrorEnum.InvalidLottoNum.getText());
        }

        return new LottoNumber(num, true);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return num - o.num;
    }
}
