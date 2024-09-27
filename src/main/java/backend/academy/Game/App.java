package backend.academy.Game;

public class App {
    private final SettingsProvider settingsProvider;
    private final Game game;

    public App(SettingsProvider settingsProvider, Game game) {
        this.settingsProvider = settingsProvider;
        this.game = game;
    }

    public void start() {
        String word = settingsProvider.getWord();
        Integer maxAttempts = SettingsProvider.MAX_ATTEMPTS;
        String hint = settingsProvider.getHint(word);

        game.start(word, maxAttempts, hint);
    }

}
