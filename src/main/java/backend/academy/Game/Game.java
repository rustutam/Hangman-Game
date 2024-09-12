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
}
