package backend.academy.Game;

import java.io.PrintStream;

public class GallowsVisualizer {
    private static final int LINE_SEPARATOR_COUNT = 20;

    private final PrintStream out;

    public GallowsVisualizer(PrintStream out) {
        this.out = out;
    }

    private void drawGallowsStates(GallowsState state) {
        switch (state) {
            case EMPTY:
                out.println(
                    """
                          _______
                         |
                         |
                         |
                         |
                         |
                        _|___"""
                );
                break;

            case ROPE:
                out.println(
                    """
                          _______
                         |      |
                         |
                         |
                         |
                         |
                        _|___"""
                );
                break;

            case HEAD:
                out.println(
                    """
                          _______
                         |      |
                         |     ( )
                         |
                         |
                         |
                        _|___"""
                );
                break;

            case BODY:
                out.println(
                    """
                          _______
                         |      |
                         |     ( )
                         |      |
                         |
                         |
                        _|___"""
                );
                break;

            case ONE_ARM:
                out.println(
                    """
                          _______
                         |      |
                         |     ( )
                         |     /|
                         |
                         |
                        _|___"""
                );
                break;
            case BOTH_ARMS:
                out.println(
                    """
                          _______
                         |      |
                         |     ( )
                         |     /|\\
                         |
                         |
                        _|___"""
                );
                break;

            case ONE_LEG:
                out.println(
                    """
                          _______
                         |      |
                         |     ( )
                         |     /|\\
                         |     /
                         |
                        _|___"""
                );
                break;

            case FULL_GALLOWS:
                out.println(
                    """
                          _______
                         |      |
                         |     ( )
                         |     /|\\
                         |     / \\
                         |
                        _|___"""
                );
                break;
            default:
                break;

        }
    }

    private void displayGameStatus(GameStatus gameStatus, Integer attempts, String word) {
        switch (gameStatus) {
            case PLAYING:
                out.println("Осталось попыток: " + attempts);
                break;

            case WIN:
                out.println("Поздравляю, вы выиграли!");
                break;

            case LOSE:
                out.println("Вы проиграли");
                out.println("Было загадано слово: " + word);
                break;

            default:
                break;
        }
    }

    public void drawInterface(GameInterfaceData data) {
        out.println("\n".repeat(LINE_SEPARATOR_COUNT));
        out.println("Игра виселица");
        out.println("Слово: " + data.hiddenWord());
        out.println("Использованные символы: " + data.usedSymbolsSet());
        if (data.hintUsed()) {
            out.println("Подсказка: " + data.hint());
        } else {
            out.println("Для получения подсказки введите 'подсказка'");
        }
        drawGallowsStates(data.state());
        displayGameStatus(data.gameStatus(), data.attempts(), data.word());
    }
}

