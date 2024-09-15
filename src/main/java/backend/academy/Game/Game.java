package backend.academy.Game;


public class Game {
    //получает настройки и создает gamelogic
    private final int MAX_ATTEMPTS = 7;
    private RandomValueProvider randomValueProvider;
    private GallowsVisualizer gallowsVisualizer;
    private ConsoleInputProvider playerInputHandler;

    private GallowsVisualizer gallowsVisualizer = new GallowsVisualizer();
    private final ConsoleInputProvider playerInputHandler = new ConsoleInputProvider();

    public void start(){
        GameLogic gameLogic = new GameLogic("rustam", 7);
        System.out.println(gameLogic.getGameInformation());
        while (true) {
            gallowsVisualizer.drawInterface(
                gameLogic.getGallowsState(),
                gameLogic.getGameStatus(),
                gameLogic.getHiddenWord(),
                gameLogic.getUsedSymbolsSet(),
                gameLogic.getAttempts());
            String inputSymbol = playerInputHandler.getInput();
            if (inputSymbol.length() == 1) {

                gameLogic.gameElementsHandler(inputSymbol);

                if (gameLogic.getGameStatus() == GameStatus.WIN) {
                    gallowsVisualizer.drawInterface(
                        gameLogic.getGallowsState(),
                        gameLogic.getGameStatus(),
                        gameLogic.getHiddenWord(),
                        gameLogic.getUsedSymbolsSet(),
                        gameLogic.getAttempts());
                    break;
                } else if (gameLogic.getGameStatus() == GameStatus.LOSE) {
                    gallowsVisualizer.drawInterface(
                        gameLogic.getGallowsState(),
                        gameLogic.getGameStatus(),
                        gameLogic.getHiddenWord(),
                        gameLogic.getUsedSymbolsSet(),
                        gameLogic.getAttempts());
                    break;
                }
            }


        }
    }
}
