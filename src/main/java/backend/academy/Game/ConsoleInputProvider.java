package backend.academy.Game;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
    Scanner scanner = new Scanner(System.in);
    @Override
    public String getInput() {
        System.out.print("Введите букву: ");
        return scanner.nextLine().toUpperCase();
    }

    public String getInputCategory(List<String> categories) {
        System.out.print("Выберите категорию: " + categories);
        return scanner.nextLine();

    }

    public String getInputLevel(List<String> levels) {
        System.out.println("Выберите уровень сложности: " + levels);
        return scanner.nextLine();
    }
}
