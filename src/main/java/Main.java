import contoller.LottoController;
import domain.LottoNumbers;
import domain.Lottos;
import view.LottoView;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        Lottos lottos = lottoController.startLottoBuy();
        LottoNumbers lottoNumbers = lottoController.getWinningNumber();




        lottoController.winningLotto(lottos,lottoNumbers);

    }
}
