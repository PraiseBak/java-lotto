package helper;


public enum LottoErrorEnum {
    NonIntegerNumError("정수가 아닌 문자열을 입력 받을 수 없습니다",401),
    NonNaturalNumError("0이하의 숫자를 입력 받을 수 없습니다",402),
    NonDividedNumError("1000으로 나누어 떨어지지 않는 금액은 입력받을 수 없습니다.",403),
    InvalidLottoList("유효하지않은 로또 번호개수입니다",405),
    InvalidLottoNum("유효하지않은 로또 숫자입니다",406),
    DuplicateLottoNum("중복된 로또 숫자입니다",407);


    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }

    private String text;
    private int code;


    LottoErrorEnum(String text,int code){
        this.text = text;
        this.code = code;
    }

}
