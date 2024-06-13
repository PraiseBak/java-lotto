package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoNumbers;
import helper.LottoErrorEnum;
import util.LottoInputValidUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoView {

    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int MAX_LOTTO_NUM = 6;


    private static void write(String string){
        try {
            bw.write(string);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("error occur" + e.getMessage() + "나중에 다시 시도해주세요");
        }
    }

    private static boolean isValidStr(String str){
        if(!LottoInputValidUtil.isIntegerStr(str)) {
            write(LottoErrorEnum.NonDividedNumError.getText());
            return false;
        }
        return true;
    }


    private static boolean isValidNum(int lottoBuyMoney){
        if(!LottoInputValidUtil.isNatural(lottoBuyMoney)) {
            write(LottoErrorEnum.NonNaturalNumError.getText());
            return false;
        }

        if(!LottoInputValidUtil.isDividedByUnit(lottoBuyMoney)) {
            write(LottoErrorEnum.NonDividedNumError.getText());
            return false;
        }
        return true;
    }

    public static int inputLottoView(){
        write("구입 금액을 입력해주세요");

        String str = sc.nextLine();
        write("입력한 금액 = " + str);

        if(!isValidStr(str)) return 0;
        int lottoBuyNum = Integer.parseInt(str);
        if(!isValidNum(lottoBuyNum)) return 0;
        return lottoBuyNum;
    }


    public static Lotto inputMakeManuelLotto() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        //로또 개수는 6개씩
        System.out.println("6개의 숫자를 입력해주세요");
        for(int lottoNum = 0;lottoNum< MAX_LOTTO_NUM;lottoNum++){
            int num = sc.nextInt();
            LottoNumber lottoNumber = new LottoNumber(num,false);
            lottoNumberList.add(lottoNumber);
        }

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList,false);
        Lotto lotto = Lotto.from(lottoNumbers);
        return lotto;
    }

    public static int inputLottoManuelBuyCount(int lottoBuyCount) {
        write("수동으로 살 복권 개수를 입력해주세요");

        int maxAffordManuelBuyCount = lottoBuyCount / 1000;
        try{
            String str = sc.nextLine();
            int num = Integer.parseInt(str);
            if(maxAffordManuelBuyCount < num) throw new IllegalArgumentException(LottoErrorEnum.InvalidLottoList.getText());
            return num;
        }catch (NumberFormatException e){
            throw new NumberFormatException(LottoErrorEnum.NonIntegerNumError.getText());
        }
    }

    public static LottoNumbers inputWinningNum() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for(int i=0;i<MAX_LOTTO_NUM+1;i++){
            int num = sc.nextInt();
            boolean isBonus = i == MAX_LOTTO_NUM;
            lottoNumberList.add(new LottoNumber(num,isBonus));
        }

        return new LottoNumbers(lottoNumberList,true);
    }
}
