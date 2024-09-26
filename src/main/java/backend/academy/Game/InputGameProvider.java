package backend.academy.Game;

public class InputGameProvider {
    private final InputProvider inputProvider;

    public InputGameProvider(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public String getInputSymbol() {
        return inputProvider.getInput("Введите букву:");
    }
}
