package baseball.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * Created by eunbi on 2022/04/18
 */
public class BaseballViewer {
    /**
     * 게임 결과를 출력
     */
    public void printGameResult(int strikeNum, int ballNum){
        String printStr = "";
        if(strikeNum == 0 && ballNum==0){
            System.out.println("낫싱");
            return;
        }
        if(strikeNum > 0 )
            printStr = strikeNum +"스트라이크 ";
        if(ballNum > 0 )
            printStr += ballNum +"볼";
        System.out.println(printStr.trim());
    }

    /**
     * 사용자에게 숫자를 넘겨받는 뷰
     * @return inputNum
     */
    public String getNumberInput(){
        //숫자를 입력해주세요 : 123
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();
        return num;
    }

    /**
     * 게임이 끝난 후 다시 시작할지 여부를 뭍는 뷰
     * @return isPlayAgin
     */
    public String getPlayAgain(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNum = Console.readLine();
        return inputNum;
    }

}
