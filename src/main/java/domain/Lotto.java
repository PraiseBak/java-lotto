package domain;

import helper.LottoErrorEnum;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    private final LottoNumbers lottoNumbers;
    private static final int MAX_LOTTO_NUM = 6;

    public Lotto(LottoNumbers lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto generateRandomLotto() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for(int i=0;i<MAX_LOTTO_NUM;i++){
            int num = RandomLottoNumberGenerateStrategy.nextInt();
            LottoNumber lottoNumber = new LottoNumber(num,false);
            lottoNumberList.add(lottoNumber);
        }
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList,false);
        return from(lottoNumbers);
    }

    public static Lotto from(LottoNumbers lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }
}
