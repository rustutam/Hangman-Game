package backend.academy.Game;

import java.util.HashSet;

public class GallowsVisualizer {

    private void drawGallowsStates(GallowsState state) {
        switch (state) {
            case EMPTY:
                System.out.println("  _______");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case ROPE:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case HEAD:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case BODY:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |      |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case ONE_ARM:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |     /|");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case BOTH_ARMS:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |     /|\\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case ONE_LEG:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |     /|\\");
                System.out.println(" |     /");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case FULL_GALLOWS:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |     /|\\");
                System.out.println(" |     / \\");
                System.out.println(" |");
                System.out.println("_|___");
                break;

        }
    }

    private void displayGameStatus(GameStatus gameStatus, Integer attempts, String word) {
        switch (gameStatus) {
            case PLAYING:
                System.out.println("Осталось попыток: " + attempts);
                break;

            case WIN:
                System.out.println("Поздравляю, вы выиграли!");
                break;

            case LOSE:
                System.out.println("Вы проиграли");
                System.out.println("Было загадано слово: " + word);
                break;
        }
    }

    public void drawInterface(
        GallowsState state,
        GameStatus gameStatus,
        String hiddenWord,
        String word,
        HashSet<String> usedSymbolsSet,
        Integer attempts
    ) {
        System.out.println("\n".repeat(20));
        System.out.println("Игра виселица");
        System.out.println("Слово: " + hiddenWord);
        System.out.println("Использованные символы: " + usedSymbolsSet);
        drawGallowsStates(state);
        displayGameStatus(gameStatus, attempts, word);
    }
}

