package domain;

import helper.LottoErrorEnum;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int MAX_LOTTO_NUM = 6;
    private final boolean isBonusContain;

    @Override
    public String toString() {
        Collections.sort(lottoNumberList);

        return lottoNumberList.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));
    }


    public boolean contains(LottoNumber lottoNumber){
        return lottoNumberList.contains(lottoNumber);

    }


    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

    private List<LottoNumber> lottoNumberList = new ArrayList<>();

    public LottoNumbers(List<LottoNumber> lottoNumbers,boolean isBonusContain){
        this.lottoNumberList = lottoNumbers;
        this.isBonusContain = isBonusContain;
        //개수 6개가 아닌 경우
        if(!isValidSize()) throw new IllegalArgumentException(LottoErrorEnum.InvalidLottoList.getText());
        //중복
        if(isDuplicate()) throw new IllegalArgumentException(LottoErrorEnum.DuplicateLottoNum.getText());
    }


    private boolean isValidSize() {
        if(isBonusContain) return lottoNumberList.size() == MAX_LOTTO_NUM+1;
        return lottoNumberList.size() == MAX_LOTTO_NUM;
    }


    public boolean isDuplicate(){
        HashSet<LottoNumber> hashSet = new HashSet<>();
        for(LottoNumber lottoNumber : lottoNumberList){
            hashSet.add(lottoNumber);
        }
        return hashSet.size() != 6;
    }

}
