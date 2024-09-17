package backend.academy.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anySet;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GameTest {
    private InputGameProvider inputGameProvider;
    private GallowsVisualizer gallowsVisualizer;
    private Game game;

    @BeforeEach
    void setUp() {
        inputGameProvider = mock(InputGameProvider.class);
        gallowsVisualizer = mock(GallowsVisualizer.class);
        game = new Game(inputGameProvider, gallowsVisualizer);
    }

    @Test
    void testStartWithInvalidWord() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> game.start("", 7)
        );
        assertEquals("Invalid input parameters", exception.getMessage());
    }

    @Test
    void testStartWithInvalidMaxAttempts() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> game.start("РОССИЯ", 0)
        );
        assertEquals("Invalid input parameters", exception.getMessage());
    }

    @Test
    void testStartWithCorrectInputWin() {
        when(inputGameProvider.getInputSymbol()).thenReturn("Р", "О", "С", "С", "И", "Я");

        game.start("РОССИЯ", 7);

        verify(gallowsVisualizer, times(1)).drawInterface(
            any(GallowsState.class),
            eq(GameStatus.WIN),
            eq("РОССИЯ"),
            eq("РОССИЯ"),
            anySet(),
            anyInt()
        );
    }

    @Test
    void testStartWithCorrectInputLose() {
        when(inputGameProvider.getInputSymbol()).thenReturn("Р", "О", "С", "С", "И", "Я");

        game.start("РОССИЯ", 7);

        verify(gallowsVisualizer, never()).drawInterface(
            any(GallowsState.class),
            eq(GameStatus.LOSE),
            eq("______"),
            eq("РОССИЯ"),
            anySet(),
            eq(0)
        );
    }

    @Test
    void testStartWithIncorrectInputWin() {
        when(inputGameProvider.getInputSymbol()).thenReturn("А", "Б", "В", "Г", "Д", "Е", "Ж");

        game.start("РОССИЯ", 7);

        verify(gallowsVisualizer, never()).drawInterface(
            any(GallowsState.class),
            eq(GameStatus.WIN),
            eq("______"),
            eq("РОССИЯ"),
            anySet(),
            eq(0)
        );
    }

    @Test
    void testStartWithIncorrectInputLose() {
        when(inputGameProvider.getInputSymbol()).thenReturn("А", "Б", "В", "Г", "Д", "Е", "Ж");

        game.start("РОССИЯ", 7);

        verify(gallowsVisualizer, times(1)).drawInterface(
            any(GallowsState.class),
            eq(GameStatus.LOSE),
            eq("______"),
            eq("РОССИЯ"),
            anySet(),
            eq(0)
        );
    }

}
