package backend.academy;

import backend.academy.Game.App;
import backend.academy.Game.ConsoleInputProvider;
import backend.academy.Game.DictionaryLoader;
import backend.academy.Game.GallowsVisualizer;
import backend.academy.Game.Game;
import backend.academy.Game.InputGameProvider;
import backend.academy.Game.InputSettingsProvider;
import backend.academy.Game.SettingsProvider;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        var in = System.in;
        var out = System.out;
        String dictionaryPath = "Game/dictionary.json";

        DictionaryLoader dictionaryLoader = new DictionaryLoader(dictionaryPath, out);
        ConsoleInputProvider consoleInputProvider = new ConsoleInputProvider(in, out);
        InputSettingsProvider inputSettingsProvider = new InputSettingsProvider(consoleInputProvider);
        GallowsVisualizer gallowsVisualizer = new GallowsVisualizer(out);
        InputGameProvider inputGameProvider = new InputGameProvider(consoleInputProvider);
        SettingsProvider settingsProvider = new SettingsProvider(out, inputSettingsProvider, dictionaryLoader);
        Game game = new Game(inputGameProvider, gallowsVisualizer);
        App app = new App(settingsProvider, game);
        app.start();
    }
}

