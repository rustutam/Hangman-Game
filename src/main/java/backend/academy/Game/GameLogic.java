package backend.academy.Game;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class GameLogic {
    private final int MAX_ATTEMPTS;
    @Getter private final String word;
    @Getter private Integer attempts;
    @Getter private GameStatus gameStatus = GameStatus.PLAYING;
    @Getter private String hiddenWord;
    @Getter private HashSet<String> usedSymbolsSet = new HashSet<>();
    @Getter private Integer gallowsState = 0;

    public GameLogic(String word, Integer attempts) {
        this.word = word;
        this.MAX_ATTEMPTS = attempts;
        this.attempts = attempts;
        hiddenWord = "_".repeat(word.length());
    }

    private List<Integer> findSymbolIndexes(String word, String symbol) {
        List<Integer> indexList = new ArrayList<>();
        int index = word.indexOf(symbol);
        while (index >= 0) {
            indexList.add(index);
            index = word.indexOf(symbol, index + 1);
        }

        return indexList;

    }

    public void gameElementsHandler(String inputSymbol) {
        List<Integer> findIndexes = findSymbolIndexes(word, inputSymbol);
        if (findIndexes.isEmpty()) {
            usedSymbolsSet.add(inputSymbol);
            attempts--;
        } else {
            for (Integer index : findIndexes) {
                hiddenWord = hiddenWord.substring(0, index) + inputSymbol + hiddenWord.substring(index + 1);
            }
        }

        if (hiddenWord.equals(word)) {
            gameStatus = GameStatus.WIN;
        }

        if (attempts <= 0) {
            gameStatus = GameStatus.LOSE;
        }

        gallowsState = (int) Math.floor(((double) (MAX_ATTEMPTS - attempts) / MAX_ATTEMPTS) * 7.0);
    }
}
