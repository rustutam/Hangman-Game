package backend.academy.Game;

public class GallowsVisualizer {

    private void drawGallowsStates(Integer state){
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

    public void drawInterface(Integer state){
        System.out.println("Игра виселица");
        System.out.println("Слово: ");
        System.out.println("Использованные буквы:");
        drawGallowsStates(state);
        System.out.println("Осталось попыток:");
    }
}

