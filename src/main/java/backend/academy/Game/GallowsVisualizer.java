package backend.academy.Game;

import java.util.HashSet;

public class GallowsVisualizer {

    private void drawGallowsStates(Integer state) {
        switch (state) {
            case 0:
                System.out.println("  _______");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case 1:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case 2:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case 3:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |      |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case 4:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |     /|");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 5:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |     /|\\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case 6:
                System.out.println("  _______");
                System.out.println(" |      |");
                System.out.println(" |     ( )");
                System.out.println(" |     /|\\");
                System.out.println(" |     /");
                System.out.println(" |");
                System.out.println("_|___");
                break;

            case 7:
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

    private void displayGameStatus(GameStatus gameStatus, Integer attempts) {
        switch (gameStatus) {
            case PLAYING:
                System.out.println("Осталось попыток: " + attempts);
                break;

            case WIN:
                System.out.println("Поздравляю, вы выиграли!");
                break;

            case LOSE:
                System.out.println("Вы проиграли");
                break;
        }
    }

    public void drawInterface(
        Integer state,
        GameStatus gameStatus,
        String hiddenWord,
        HashSet<String> usedSymbolsSet,
        Integer attempts
    ) {
        System.out.println("\n".repeat(20));
        System.out.println("Игра виселица");
        System.out.println("Слово: " + hiddenWord);
        System.out.println("Использованные символы: " + usedSymbolsSet);
        drawGallowsStates(state);
        displayGameStatus(gameStatus, attempts);
    }
}

