package baseball.model;

import java.util.ArrayList;

/**
 * Created by eunbi on 2022/04/18
 */
public class Ball {
    String inputNum ;
    String result;
    int index ;

    public void setResult(ArrayList<String> numList) {
        if (!numList.contains(inputNum)) {
            this.result = "N";
            return;
        }
        if(inputNum.equalsIgnoreCase(numList.get(index))){
            this.result = "S";
            return;
        }
        this.result = "B";
    }
}
