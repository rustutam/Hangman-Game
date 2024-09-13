package backend.academy.Game;

import java.util.List;

public class ConsoleInputProvider implements InputProvider {
    @Override
    public String getInput() {
        System.out.print("Введите букву: ");
        return System.console().readLine();
    }

    public String getInputCategory(List<String> categories) {
        System.out.print("Выберите категорию: " + categories);
        return System.console().readLine();

    }

    public String getInputLevel(List<String> levels) {
        System.out.println("Выберите уровень сложности: " + levels);
        return System.console().readLine();
    }
}
