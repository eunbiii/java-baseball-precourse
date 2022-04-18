package baseball;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameController baseballGameController = new GameController();

        do{
            baseballGameController.startGame();
        }while (baseballGameController.isPlayAgain());
    }
}
