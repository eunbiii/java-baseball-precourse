package baseball.controller;

import baseball.model.Ball;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunbi on 2022/04/18
 */
public class GameValidator {
    public void checkBallCount(String inputNum){
        if( inputNum.length()!=3){
            System.out.println("게임 종료");
            throw new IllegalArgumentException();
        }
    }

    public void checkBallNum (String ballNo){
        int ballNum = Integer.parseInt(ballNo);
        if (ballNum<1 || ballNum > 9){
            System.out.println("게임 종료");
            throw new IllegalArgumentException();
        }
    }

    public void checkInputNum(String inputNum){
        checkBallCount(inputNum);

        String[] numList = inputNum.split("");
        for (String num : numList){
            checkBallNum(num);
        }
    }

    public boolean checkUserInput (String inputNum){
        return inputNum.equalsIgnoreCase("1") || inputNum.equalsIgnoreCase("2");
    }

    public void setBallResult(Ball ball, List<String> numList) {
        String inputNum = ball.getInputNum();
        int index = ball.getIndex();
        if (!numList.contains(inputNum)) {
            ball.setResult("N");
            return;
        }
        if(inputNum.equalsIgnoreCase(numList.get(index))){
            ball.setResult("S");
            return;
        }
        ball.setResult("B");
    }

    /**
     * 새로 시작할지 체크하는 함수
     * @return  새로 시작 여부
     */
    public boolean isPlayAgain(String inputNum){
        if ("1".equalsIgnoreCase(inputNum))
            return true;
        if("2".equalsIgnoreCase(inputNum))
            return false;
        throw new IllegalStateException();
    }

}
