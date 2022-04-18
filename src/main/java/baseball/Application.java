package baseball;

import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) throws Exception {
    BaseballGameController baseballGameController = new BaseballGameController();

        do{
            baseballGameController.startGame();
        }while (baseballGameController.isPlayAgain());
    }
}
