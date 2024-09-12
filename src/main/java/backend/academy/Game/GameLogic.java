package backend.academy.Game;

import java.util.HashSet;

public class GameLogic {
    private String word;
    private Integer attempts;
    private String userInput;
    private HashSet<String> usedSymbolsSet = new HashSet<>();
    ConsoleInputProvider playerInput = new ConsoleInputProvider();
    GallowsVisualizer gallowsVisualizer = new GallowsVisualizer();

    public GameLogic(String word, Integer attempts) {
        this.word = word;
        this.attempts = attempts;
    }

    public void game() {



        while (attempts>0){
            gallowsVisualizer.drawInterface(0);
            userInput = playerInput.getInput();



        }
    }
}
