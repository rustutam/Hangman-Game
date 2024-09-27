package backend.academy.Game;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GallowsVisualizerTest {

    private GallowsVisualizer gallowsVisualizer;
    private PrintStream mockOut;

    @BeforeEach
    void setUp() {
        mockOut = mock(PrintStream.class);
        gallowsVisualizer = new GallowsVisualizer(mockOut);
    }

    @Test
    void testDrawInterfaceWin() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.EMPTY,
            GameStatus.WIN,
            "РОССИЯ",
            "РОССИЯ",
            usedSymbols,
            3,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: РОССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |
             |
             |
             |
             |
            _|___""");
        verify(mockOut).println("Поздравляю, вы выиграли!");
    }

    @Test
    void testDrawInterfaceLose() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.FULL_GALLOWS,
            GameStatus.LOSE,
            "__СС__",
            "РОССИЯ",
            usedSymbols,
            0,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: __СС__");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |     /|\\
             |     / \\
             |
            _|___""");
        verify(mockOut).println("Вы проиграли");
        verify(mockOut).println("Было загадано слово: РОССИЯ");
    }

    @Test
    void testDrawInterfacePlayingEmpty() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.EMPTY,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |
             |
             |
             |
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingRope() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.ROPE,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |
             |
             |
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingHead() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.HEAD,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |
             |
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingBody() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.BODY,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |      |
             |
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingOneArm() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.ONE_ARM,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |     /|
             |
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingBothArms() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.BOTH_ARMS,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |     /|\\
             |
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingOneLeg() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.ONE_LEG,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |     /|\\
             |     /
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingFullGallows() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.FULL_GALLOWS,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            false
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Для получения подсказки введите 'подсказка'");
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |     /|\\
             |     / \\
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfacePlayingWithHint() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.FULL_GALLOWS,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2,
            "Самая большая страна",
            true
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Подсказка: " + data.hint());
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |     /|\\
             |     / \\
             |
            _|___""");
        verify(mockOut).println("Осталось попыток: 2");
    }

    @Test
    void testDrawInterfaceLoseWithHint() {
        // Arrange
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");
        GameInterfaceData data = new GameInterfaceData(
            GallowsState.FULL_GALLOWS,
            GameStatus.LOSE,
            "__СС__",
            "РОССИЯ",
            usedSymbols,
            0,
            "Самая большая страна",
            true
        );

        // Act
        gallowsVisualizer.drawInterface(data);

        // Assert
        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: __СС__");
        verify(mockOut).println("Использованные символы: [A]");
        verify(mockOut).println("Подсказка: " + data.hint());
        verify(mockOut).println("""
              _______
             |      |
             |     ( )
             |     /|\\
             |     / \\
             |
            _|___""");
        verify(mockOut).println("Вы проиграли");
        verify(mockOut).println("Было загадано слово: РОССИЯ");
    }
}
