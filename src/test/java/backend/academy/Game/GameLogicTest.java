package backend.academy.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameLogicTest {
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameLogic = new GameLogic("РОССИЯ", 7);
    }

    @Test
    void testGameElementsHandlerNullGuess() {
        gameLogic.gameElementsHandler("");
        assertEquals("______", gameLogic.hiddenWord());
        assertEquals(7, gameLogic.attempts());
    }

    @Test
    void testGameElementsHandlerIncorrectGuess() {
        gameLogic.gameElementsHandler("А");
        assertEquals("______", gameLogic.hiddenWord());
        assertEquals(6, gameLogic.attempts());
        assertTrue(gameLogic.usedSymbolsSet().contains("А"));
    }

    @Test
    void testGameElementsHandlerCorrectGuess() {
        gameLogic.gameElementsHandler("С");

        assertEquals("__СС__", gameLogic.hiddenWord());
    }

    @Test
    void testGameWinCondition() {
        gameLogic.gameElementsHandler("Р");
        gameLogic.gameElementsHandler("О");
        gameLogic.gameElementsHandler("С");
        gameLogic.gameElementsHandler("И");
        gameLogic.gameElementsHandler("Я");

        assertEquals(GameStatus.WIN, gameLogic.gameStatus());
    }

    @Test
    void testGameLoseCondition() {
        gameLogic.gameElementsHandler("А");
        gameLogic.gameElementsHandler("Б");
        gameLogic.gameElementsHandler("В");
        gameLogic.gameElementsHandler("Г");
        gameLogic.gameElementsHandler("Д");
        gameLogic.gameElementsHandler("Е");
        gameLogic.gameElementsHandler("Ж");

        assertEquals(GameStatus.LOSE, gameLogic.gameStatus());
    }

    @Test
    void testGallowsState() {
        gameLogic.gameElementsHandler("А");
        assertEquals(GallowsState.ROPE, gameLogic.gallowsState());

        gameLogic.gameElementsHandler("Б");
        assertEquals(GallowsState.HEAD, gameLogic.gallowsState());

        gameLogic.gameElementsHandler("Р");
        assertEquals(GallowsState.HEAD, gameLogic.gallowsState());

        gameLogic.gameElementsHandler("У");
        assertEquals(GallowsState.BODY, gameLogic.gallowsState());

        gameLogic.gameElementsHandler("Ы");
        assertEquals(GallowsState.ONE_ARM, gameLogic.gallowsState());

        gameLogic.gameElementsHandler("Н");
        assertEquals(GallowsState.BOTH_ARMS, gameLogic.gallowsState());

        gameLogic.gameElementsHandler("К");
        assertEquals(GallowsState.ONE_LEG, gameLogic.gallowsState());

        gameLogic.gameElementsHandler("В");
        assertEquals(GallowsState.FULL_GALLOWS, gameLogic.gallowsState());
    }

}
