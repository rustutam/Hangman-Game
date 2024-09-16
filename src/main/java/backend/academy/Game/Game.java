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
        gallowsVisualizer.drawInterface(
            gameLogic.gallowsState(),
            gameLogic.gameStatus(),
            gameLogic.hiddenWord(),
            gameLogic.word(),
            gameLogic.usedSymbolsSet(),
            gameLogic.attempts()
        );
    }

    public void start(String word, Integer MAX_ATTEMPTS) {
        GameLogic gameLogic = new GameLogic(word, MAX_ATTEMPTS);
        while (true) {
            drawGameInterface(gameLogic);
            String inputSymbol = inputGameProvider.getInputSymbol();
            if (inputSymbol.length() == 1) {

                gameLogic.gameElementsHandler(inputSymbol);

                if ((gameLogic.gameStatus() == GameStatus.WIN) || (gameLogic.gameStatus() == GameStatus.LOSE)) {
                    drawGameInterface(gameLogic);
                    break;
                }
            }
        }
    }
}
