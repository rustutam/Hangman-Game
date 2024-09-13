package backend.academy.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    //получает настройки и создает gamelogic
    private final int MAX_ATTEMPTS = 7;
    private RandomValueProvider randomValueProvider;
    private GallowsVisualizer gallowsVisualizer;
    private ConsoleInputProvider playerInputHandler;

    public Game() {
        this.randomValueProvider = new RandomValueProvider();
        this.gallowsVisualizer = new GallowsVisualizer();
        this.playerInputHandler = new ConsoleInputProvider();
    }

    public void start(){
        GameLogic gameLogic = new GameLogic("rustam", 7);
        System.out.println(gameLogic.getGameInformarion());
        while (gameLogic.getAttempts() > 0){
            String inputSymbol = playerInputHandler.getInput();
            gameLogic.gameElementsHandler(inputSymbol);

            System.out.println(gameLogic.getGameInformarion());

        }
    }
}
