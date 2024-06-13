package contoller;

import domain.Lotto;
import domain.LottoNumber;
import domain.LottoNumbers;
import domain.Lottos;
import view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public Lottos startLottoBuy(){
        while (true){
            try{

                //구입금액 정하기
                int lottoBuyMoney = LottoView.inputLottoView();
                if(lottoBuyMoney <= 0) continue;

                //수동으로 구매할 개수 정하기
                int lottoByManualCount = LottoView.inputLottoManuelBuyCount(lottoBuyMoney);

                int leftLottoCount = lottoBuyMoney / 1000 - lottoByManualCount;

                List<Lotto> lottoList = new ArrayList<>();

                for(int i=0;i<lottoByManualCount;i++){
                    Lotto lotto = LottoView.inputMakeManuelLotto();
                    lottoList.add(lotto);
                }


                for(int i=0;i<leftLottoCount;i++){
                    Lotto lotto = Lotto.generateRandomLotto();
                    lottoList.add(lotto);
                }

                Lottos lottos = new Lottos(lottoList);
                System.out.println("출력된 로또입니다");
                System.out.println(lottos);
                return lottos;

            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("다시 시작합니다");
            }
        }


    }


    public void winningLotto() {
    }

    public LottoNumbers getWinningNumber() {
        return LottoView.inputWinningNum();
    }

    public void winningLotto(Lottos lottos, LottoNumbers lottoNumbers) {
        int count = 0;
        boolean isBonusCollect = false;
        for(LottoNumber lottoNumber : lottoNumbers.getLottoNumberList()){
            for(Lotto lotto: lottos.getLottos()){
                if(!lotto.contains(lottoNumber)) continue;

                count++;
                if(lottoNumber.isBonus()) isBonusCollect = true;
            }

        }
    }
}
