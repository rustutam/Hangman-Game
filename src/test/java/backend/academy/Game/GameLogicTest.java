package backend.academy.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameLogicTest {
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        // Arrange
        gameLogic = new GameLogic("РОССИЯ", 7, "Самая большая страна мире");
    }

    @Test
    void testGameElementsHandlerHintInput() {

        // Act
        gameLogic.gameElementsHandler("ПОДСКАЗКА");

        // Assert
        assertEquals("______", gameLogic.hiddenWord());
        assertEquals(7, gameLogic.attempts());
        assertTrue(gameLogic.hintUsed());
    }

    @Test
    void testGameElementsHandlerNullGuess() {

        // Act
        gameLogic.gameElementsHandler("");

        // Assert
        assertEquals("______", gameLogic.hiddenWord());
        assertEquals(7, gameLogic.attempts());
        assertFalse(gameLogic.hintUsed());
    }

    @Test
    void testGameElementsHandlerIncorrectGuess() {

        // Act
        gameLogic.gameElementsHandler("А");

        // Assert
        assertEquals("______", gameLogic.hiddenWord());
        assertEquals(6, gameLogic.attempts());
        assertTrue(gameLogic.usedSymbolsSet().contains("А"));
    }

    @Test
    void testGameElementsHandlerCorrectGuess() {

        // Act
        gameLogic.gameElementsHandler("С");

        // Assert
        assertEquals("__СС__", gameLogic.hiddenWord());
    }

    @Test
    void testGameWinCondition() {

        // Act
        gameLogic.gameElementsHandler("Р");
        gameLogic.gameElementsHandler("О");
        gameLogic.gameElementsHandler("С");
        gameLogic.gameElementsHandler("И");
        gameLogic.gameElementsHandler("Я");

        // Assert
        assertEquals(GameStatus.WIN, gameLogic.gameStatus());
    }

    @Test
    void testGameLoseCondition() {

        // Act
        gameLogic.gameElementsHandler("А");
        gameLogic.gameElementsHandler("Б");
        gameLogic.gameElementsHandler("В");
        gameLogic.gameElementsHandler("Г");
        gameLogic.gameElementsHandler("Д");
        gameLogic.gameElementsHandler("Е");
        gameLogic.gameElementsHandler("Ж");

        // Assert
        assertEquals(GameStatus.LOSE, gameLogic.gameStatus());
    }

    @Test
    void testGallowsState() {

        // Act
        gameLogic.gameElementsHandler("А");

        // Assert
        assertEquals(GallowsState.ROPE, gameLogic.gallowsState());

        // Act
        gameLogic.gameElementsHandler("Б");

        // Assert
        assertEquals(GallowsState.HEAD, gameLogic.gallowsState());

        // Act
        gameLogic.gameElementsHandler("Р");

        // Assert
        assertEquals(GallowsState.HEAD, gameLogic.gallowsState());

        // Act
        gameLogic.gameElementsHandler("У");

        // Assert
        assertEquals(GallowsState.BODY, gameLogic.gallowsState());

        // Act
        gameLogic.gameElementsHandler("Ы");

        // Assert
        assertEquals(GallowsState.ONE_ARM, gameLogic.gallowsState());

        // Act
        gameLogic.gameElementsHandler("Н");

        // Assert
        assertEquals(GallowsState.BOTH_ARMS, gameLogic.gallowsState());

        // Act
        gameLogic.gameElementsHandler("К");

        // Assert
        assertEquals(GallowsState.ONE_LEG, gameLogic.gallowsState());

        // Act
        gameLogic.gameElementsHandler("В");

        // Assert
        assertEquals(GallowsState.FULL_GALLOWS, gameLogic.gallowsState());
    }

}
