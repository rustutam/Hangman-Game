package backend.academy.Game;

public class Game {
    private final InputGameProvider inputGameProvider;
    private final GallowsVisualizer gallowsVisualizer;

    public Game(
        InputGameProvider inputGameProvider,
        GallowsVisualizer gallowsVisualizer
    ) {
        this.inputGameProvider = inputGameProvider;
        this.gallowsVisualizer = gallowsVisualizer;
    }

    private void drawGameInterface(GameLogic gameLogic) {
        GameInterfaceData data = new GameInterfaceData(
            gameLogic.gallowsState(),
            gameLogic.gameStatus(),
            gameLogic.hiddenWord(),
            gameLogic.word(),
            gameLogic.usedSymbolsSet(),
            gameLogic.attempts(),
            gameLogic.hint(),
            gameLogic.hintUsed()
        );
        gallowsVisualizer.drawInterface(data);
    }

    public void start(String word, Integer maxAttempts, String hint) {
        if (word == null || word.isEmpty() || maxAttempts == null || maxAttempts <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        GameLogic gameLogic = new GameLogic(word, maxAttempts, hint);
        while (true) {
            drawGameInterface(gameLogic);
            String inputSymbol = inputGameProvider.getInputSymbol();
            gameLogic.gameElementsHandler(inputSymbol);

            if ((gameLogic.gameStatus() == GameStatus.WIN) || (gameLogic.gameStatus() == GameStatus.LOSE)) {
                drawGameInterface(gameLogic);
                break;
            }

        }
    }
}
