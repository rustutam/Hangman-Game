package backend.academy.Game;

import java.util.ArrayList;
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

    private ArrayList<Integer> getAllIndexesInWord(String word, String symbol) {
        ArrayList<Integer> indexList = new ArrayList<>();
        int index = word.indexOf(symbol);
        while (index >= 0) {
            indexList.add(index);
            index = word.indexOf(symbol, index + 1);
        }

        return indexList;

    }

    public void game() {

        while (attempts > 0) {
            gallowsVisualizer.drawInterface(0);
            userInput = playerInput.getInput();
            ArrayList<Integer> indexes = getAllIndexesInWord(word, userInput);
            attempts--;
            if (indexes.isEmpty()) {
                usedSymbolsSet.add(userInput);
            } else {
                for (Integer index : indexes) {
                    hiddenWord = hiddenWord.substring(0, index) + userInput + hiddenWord.substring(index + 1);
                }
            }
        }
    }
}
