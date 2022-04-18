package baseball.controller;

import baseball.model.Ball;
import baseball.model.BaseballGame;
import baseball.view.BaseballViewer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eunbi on 2022/04/18
 */
public class GameController {
    String userRestartNum = "";
    BaseballGame baseballGame = new BaseballGame();
    BaseballViewer baseballViewer = new BaseballViewer();
    GameValidator gameValidator = new GameValidator();

    // 게임을 시작하지.
    public void startGame(){
        // 게임 초기화
        initGame(baseballGame);
        while(!baseballGame.isGameEnd()){
            doGame();
        }
        if(baseballGame.isWin()){
            System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        }
        System.out.println("게임 종료");
    }

    // 게임을 한다.
    public void doGame(){
        initCount(baseballGame);

        //1. 숫자 입력받음
        String inputNum = baseballViewer.getNumberInput();
        // 사용자 예외 입력 체크
        if(gameValidator.checkUserInput(inputNum)){
            userRestartNum = inputNum;
            baseballGame.setGameEnd(true);
            return;
        }

        //inputNum 체크 및 리스트로 변환
        gameValidator.checkInputNum(inputNum);
        baseballGame.setInputNumList(getBallList(inputNum));

        //2. 숫자 판별
        setBallResult(baseballGame);

        //3. 정답 판별 및 분기
        setResultEnd();
    }

    public void setResultEnd(){
        baseballViewer.printGameResult(baseballGame.getStrikeNum(), baseballGame.getBallNum());
        baseballGame.setGameEnd(baseballGame.getStrikeNum()==3 );
        baseballGame.setWin(baseballGame.getStrikeNum()==3 );
    }


    //입력한 숫자를 볼 리스트로 반환한다.
    public List<Ball> getBallList(String inputNum){
        List<Ball> ballList = new ArrayList<>();
        String[] numList = inputNum.split("");
        for (int i=0; i<numList.length ;i ++){
            ballList.add(new Ball(numList[i], i));
        }
        return ballList;
    }

    // 각 공의 결과값을 저장한다
    public void setBallResult(BaseballGame baseballGame){
        List<Ball> ballList = baseballGame.getInputNumList();
        List<String> randomNumList = baseballGame.getRandomNumList();
        for(Ball b : ballList){
            gameValidator.setBallResult(b , randomNumList);
        }
        for(Ball b : ballList){
            setResultNum(b, baseballGame);
        }
    }
    // 결과값의 개수를 센다
    public void setResultNum(Ball ball , BaseballGame baseballGame){
        String result = ball.getResult();
        if("S".equalsIgnoreCase(result)){
            baseballGame.setStrikeNumAdd();
        }
        if("B".equalsIgnoreCase(result)){
            baseballGame.setBallNumAdd();
        }
    }



    // 게임 초기화
    public void initGame(BaseballGame baseballGame){
        userRestartNum = "";
        baseballGame.setRandomNumList(getRandomNumList());
        baseballGame.setGameEnd (false);
        baseballGame.setWin(false);
    }
    // 카운트 초기화
    public void initCount(BaseballGame baseballGame){
        baseballGame.setStrikeNum(0);
        baseballGame.setBallNum(0);
    }

    /**
     * 1-9 사이의 서로 다른 수로 이루어진 3자리의 수를 만든다.
     * @return randomNumList
     */
    public List<String> getRandomNumList(){
        List<String> randomNumList = new ArrayList<>();
        for(int i=0 ; i <3 ; i++) {
            String randomNum = getUniqueRandomNum(randomNumList);
            randomNumList.add(randomNum);
        }
        return randomNumList;
    }

    // 리스트에 포함되지 않은 랜덤 난수를 get
    public String getUniqueRandomNum(List<String> randomNumList){
        int pickNum = 1;
        do {
            pickNum=Randoms.pickNumberInRange(1, 9);
        }while(randomNumList.contains(String.valueOf(pickNum)));
        return String.valueOf(pickNum);
    }


    /**
     * 새로 시작할지 체크하는 함수
     * @return  새로 시작 여부
     */
    public boolean isPlayAgain() {
        if(userRestartNum.equalsIgnoreCase("1")){
            return true;
        }
        if(userRestartNum.equalsIgnoreCase("2")){
            return false;
        }


        String inputNum = baseballViewer.getPlayAgain();
        return gameValidator.isPlayAgain(inputNum);
    }
}
