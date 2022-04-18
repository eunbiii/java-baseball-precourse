package baseball.model;


import java.util.ArrayList;
import java.util.List;

/**
 * 게임에 필요한 정보를 담은 모델
 * Created by eunbi on 2022/04/17
 */
public class BaseballGame {
    private int strikeNum =0;
    private int ballNum = 0;
    private boolean isGameEnd = false;
    private boolean isWin = false;
    private List<String> randomNumList = new ArrayList<>();
    private List<Ball> inputNumList = new ArrayList<>();


    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        isGameEnd = gameEnd;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public void setStrikeNum(int strikeNum) {
        this.strikeNum = strikeNum;
    }

    public void setStrikeNumAdd(){
        this.strikeNum++;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    public void setBallNumAdd(){
        this.ballNum++;
    }

    public void setRandomNumList(List<String> randomNumList) {
        this.randomNumList = randomNumList;
    }

    public void setInputNumList(List<Ball> inputNumList) {
        this.inputNumList = inputNumList;
    }

    public List<String> getRandomNumList() {
        return randomNumList;
    }

    public List<Ball> getInputNumList() {
        return inputNumList;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
