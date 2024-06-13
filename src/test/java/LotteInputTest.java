import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LottoInputValidUtil;
import view.LottoView;

import static org.junit.jupiter.api.Assertions.*;

public class LotteInputTest {

    @Test
    @DisplayName("(입력값 검증) 정수가 아닌 문자열을 입력 받을 수 없다.")
    void wrongInputStringTest() {
        String falseStr = "asdf";
        String trueStr =  "1234";
        assertSame(LottoInputValidUtil.isIntegerStr(trueStr),true);
        assertSame(LottoInputValidUtil.isIntegerStr(falseStr),false);
    }

    /**
     * todo
     * 이부분 뷰에서 내부적으로 LottoInputValidUtil을 사용해서 하는 방식인데
     * 테스트시에 실제로 뷰를 통해서 테스트하는게 아니어도 되나?
     */
    @Test
    @DisplayName(" (입력값 검증) 0이하의 숫자를 입력 받을 수 없다.")
    void 입력_0_이하의_숫자_입력케이스(){
        int zero = 0;
        int minus = -1;
        int natural = 1;
        assertSame(LottoInputValidUtil.isNatural(zero),false);
        assertSame(LottoInputValidUtil.isNatural(minus),false);
        assertSame(LottoInputValidUtil.isNatural(natural),true);
    }

    @Test
    @DisplayName("(입력값 검증, 선택) 1000으로 나누어 떨어지지 않는 금액은 입력받을 수 없다.")
    void 입력_나누어떨어지지_않는_금액(){
        int trueNum = 1000;
        int falseNum = 1001;
        assertSame(LottoInputValidUtil.isDividedByUnit(trueNum),true);
        assertSame(LottoInputValidUtil.isDividedByUnit(falseNum),false);
    }
}
