package backend.academy.Game;

import java.util.List;

public class InputSettingsProvider {
    private final InputProvider inputProvider;

    public InputSettingsProvider(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public String getInputCategory(List<String> categories) {
        return inputProvider.getInput("Выберите категорию:" + categories);
    }

    public String getInputLevel(List<String> levels) {
        return inputProvider.getInput("Выберите уровень сложности:" + levels);

    }
}
