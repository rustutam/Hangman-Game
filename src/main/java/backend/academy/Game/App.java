package backend.academy.Game;

import java.io.InputStream;
import java.io.PrintStream;

public class App {
    String dictionaryPath = "Game/dictionary.json";
    DictionaryLoader dictionaryLoader;
    ConsoleInputProvider consoleInputProvider;
    InputSettingsProvider inputSettingsProvider;
    SettingsProvider settingsProvider;

    GallowsVisualizer gallowsVisualizer;
    InputGameProvider inputGameProvider;
    Game game;

    public App(InputStream in, PrintStream out) {
        this.dictionaryLoader = new DictionaryLoader(dictionaryPath, out);
        this.consoleInputProvider = new ConsoleInputProvider(in, out);
        this.inputSettingsProvider = new InputSettingsProvider(consoleInputProvider);
        this.settingsProvider = new SettingsProvider(out, inputSettingsProvider, dictionaryLoader);
        this.gallowsVisualizer = new GallowsVisualizer(out);
        this.inputGameProvider = new InputGameProvider(consoleInputProvider);
        this.game = new Game(inputGameProvider, gallowsVisualizer);
    }

    public void start() {
        String word = settingsProvider.getWord();
        Integer maxAttempts = SettingsProvider.MAX_ATTEMPTS;

        game.start(word, maxAttempts);
    }

}
