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
        hiddenWord = "_".repeat(word.length());
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

    public void gameElementsHandler(String inputSymbol) {
        List<Integer> findIndexes = getAllIndexesInWord(word, inputSymbol);
        if (findIndexes.isEmpty()) {
            usedSymbolsSet.add(inputSymbol);
            attempts--;
        } else {
            for (Integer index : findIndexes) {
                hiddenWord = hiddenWord.substring(0, index) + inputSymbol + hiddenWord.substring(index + 1);
            }
        }

//        while (attempts > 0) {
//            gallowsVisualizer.drawInterface(0);
//            inputSymbol = playerInput.getInput();
//            ArrayList<Integer> indexes = getAllIndexesInWord(word, inputSymbol);
//            attempts--;
//            if (indexes.isEmpty()) {
//                usedSymbolsSet.add(inputSymbol);
//            } else {
//                for (Integer index : indexes) {
//                    hiddenWord = hiddenWord.substring(0, index) + inputSymbol + hiddenWord.substring(index + 1);
//                }
//            }
//        }
    }

    public HashSet<String> getUsedSymbolsSet() {
        return usedSymbolsSet;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }
}
