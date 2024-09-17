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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.EMPTY,
            GameStatus.WIN,
            "РОССИЯ",
            "РОССИЯ",
            usedSymbols,
            3
        );

        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: РОССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.FULL_GALLOWS,
            GameStatus.LOSE,
            "__СС__",
            "РОССИЯ",
            usedSymbols,
            0
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: __СС__");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.EMPTY,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.ROPE,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.HEAD,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.BODY,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.ONE_ARM,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.BOTH_ARMS,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.ONE_LEG,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
        Set<String> usedSymbols = new HashSet<>();
        usedSymbols.add("A");

        gallowsVisualizer.drawInterface(
            GallowsState.FULL_GALLOWS,
            GameStatus.PLAYING,
            "Р_ССИЯ",
            "РОССИЯ",
            usedSymbols,
            2
        );

        verify(mockOut, atLeastOnce()).println(anyString());
        verify(mockOut).println("\n".repeat(20));
        verify(mockOut).println("Игра виселица");
        verify(mockOut).println("Слово: Р_ССИЯ");
        verify(mockOut).println("Использованные символы: [A]");
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
}
