package backend.academy.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class GameLogic {
    private String word;
    private Integer attempts;

    private String hiddenWord;
    private HashSet<String> usedSymbolsSet = new HashSet<>();

    public GameLogic(String word, Integer attempts) {
        this.word = word;
        this.attempts = attempts;
        hiddenWord = "_".repeat(word.length());
    }

    private List<Integer> getAllIndexesInWord(String word, String symbol) {
        List<Integer> indexList = new ArrayList<>();
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

    public String getGameInformartion() {
        return "Hidden word: " + hiddenWord + "\n" +
            "Used symbols: " + usedSymbolsSet + "\n" +
            "Attempts: " + attempts;
    }
}
