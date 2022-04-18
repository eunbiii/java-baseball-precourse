package baseball.model;

import java.util.ArrayList;

/**
 * Created by eunbi on 2022/04/18
 */
public class Ball {
    String inputNum ;
    String result;
    int index ;

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
