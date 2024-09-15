package backend.academy.Game;


public class Game {
    //получает настройки и создает gamelogic
    private final int MAX_ATTEMPTS = 7;
    private RandomValueProvider randomValueProvider;
    private GallowsVisualizer gallowsVisualizer;
    private ConsoleInputProvider playerInputHandler;

    public Game() {
        this.randomValueProvider = new RandomValueProvider();
        this.gallowsVisualizer = new GallowsVisualizer();
        this.playerInputHandler = new ConsoleInputProvider();
    }

    public void start(){
        GameLogic gameLogic = new GameLogic("rustam", 7);
        System.out.println(gameLogic.getGameInformation());
        while (true) {
            String inputSymbol = playerInputHandler.getInput();
            gameLogic.gameElementsHandler(inputSymbol);

            System.out.println(gameLogic.getGameInformation());
            if (gameLogic.getGameStatus() == GameStatus.WIN){
                System.out.println("WIN");
                break;
            }
            else if (gameLogic.getGameStatus() == GameStatus.LOSE){
                System.out.println("Losee");
                break;
            }


        }
    }
}
