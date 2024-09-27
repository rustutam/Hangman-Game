package backend.academy.Game;

import java.util.Set;

public record GameInterfaceData(GallowsState state,
                                GameStatus gameStatus,
                                String hiddenWord,
                                String word,
                                Set<String> usedSymbolsSet,
                                Integer attempts,
                                String hint,
                                Boolean hintUsed) {

}
