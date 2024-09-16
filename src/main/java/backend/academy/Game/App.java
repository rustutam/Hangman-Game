package backend.academy.Game;

public class App {
    private final String dictionaryPath = "src/main/java/backend/academy/Game/dictionary.json";
    private final DictionaryLoader dictionaryLoader = new DictionaryLoader(dictionaryPath);
    ConsoleInputProvider consoleInputProvider = new ConsoleInputProvider();
    InputSettingsProvider inputSettingsProvider = new InputSettingsProvider(consoleInputProvider);
    SettingsProvider settingsProvider = new SettingsProvider(inputSettingsProvider, dictionaryLoader);

    GallowsVisualizer gallowsVisualizer = new GallowsVisualizer();
    InputGameProvider inputGameProvider = new InputGameProvider(consoleInputProvider);
    Game game = new Game(inputGameProvider, gallowsVisualizer);

    public void start() {
        String word = settingsProvider.getWord();
        Integer maxAttempts = settingsProvider.maxAttempts;

        game.start(word, maxAttempts);
    }

}
