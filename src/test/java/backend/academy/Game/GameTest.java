package backend.academy.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GameTest {
    private InputGameProvider inputGameProvider;
    private GallowsVisualizer gallowsVisualizer;
    private Game game;

    @BeforeEach
    void setUp() {
        // Arrange
        inputGameProvider = mock(InputGameProvider.class);
        gallowsVisualizer = mock(GallowsVisualizer.class);
        game = new Game(inputGameProvider, gallowsVisualizer);
    }

    @Test
    void testStartWithInvalidWord() {
        // Act
        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> game.start("", 7, "test")
            );

        // Assert
        assertEquals("Invalid input parameters", exception.getMessage());
    }

    @Test
    void testStartWithInvalidMaxAttempts() {
        // Act
        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> game.start("РОССИЯ", 0, "test")
            );

        // Assert
        assertEquals("Invalid input parameters", exception.getMessage());
    }

    @Test
    void testStartWithCorrectInputWin() {
        // Arrange
        when(inputGameProvider.getInputSymbol()).thenReturn("Р", "О", "С", "С", "И", "Я");

        // Act
        game.start("РОССИЯ", 7, "test");

        // Assert
        verify(gallowsVisualizer, times(7)).drawInterface(
            any(GameInterfaceData.class)
        );
    }

    @Test
    void testStartWithIncorrectInputLose() {
        // Arrange
        when(inputGameProvider.getInputSymbol()).thenReturn("А", "Б", "В", "Г", "Д", "Е", "Ж");

        // Act
        game.start("РОССИЯ", 7, "test");

        // Assert
        verify(gallowsVisualizer, times(8)).drawInterface(any(GameInterfaceData.class));
    }

}
