package baseball.model;

/**
 * Created by eunbi on 2022/04/18
 */
public class Ball {
    private String inputNum ;       // 입력 숫자
    private int index ;             //입력 위치
    private String result;          // 결과 (S:스트라이크, B:볼, N:낫싱)

    public Ball(String inputNum, int index) {
        this.inputNum = inputNum;
        this.index = index;
    }

    public String getInputNum() {
        return inputNum;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getIndex() {
        return index;
    }

}
