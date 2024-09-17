package backend.academy.Game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lombok.Getter;

public class GameLogic {
    private static final double GALLOWS_STATES_COUNT = 7.0;
    private final int maxAttempts;
    @Getter private final String word;
    @Getter private Integer attempts;
    @Getter private GameStatus gameStatus = GameStatus.PLAYING;
    @Getter private String hiddenWord;
    StringBuilder hiddenWordBuilder;
    @Getter private HashSet<String> usedSymbolsSet = new HashSet<>();
    @Getter private GallowsState gallowsState = GallowsState.EMPTY;

    public GameLogic(String word, Integer attempts) {
        this.word = word;
        this.maxAttempts = attempts;
        this.attempts = attempts;
        hiddenWord = "_".repeat(word.length());
        hiddenWordBuilder = new StringBuilder(hiddenWord);
    }

    private List<Integer> findSymbolIndexes(String word, String symbol) {
        List<Integer> indexList = new ArrayList<>(word.length());
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
                hiddenWordBuilder.setCharAt(index, inputSymbol.charAt(0));
            }
            hiddenWord = hiddenWordBuilder.toString();
        }

        if (hiddenWord.equals(word)) {
            gameStatus = GameStatus.WIN;
        }

        if (attempts <= 0) {
            gameStatus = GameStatus.LOSE;
        }

        gallowsState = GallowsState.values()[(int) Math.floor(
            ((double) (maxAttempts - attempts) / maxAttempts) * GALLOWS_STATES_COUNT)];
    }
}
