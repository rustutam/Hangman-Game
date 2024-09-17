package backend.academy.Game;

import java.io.PrintStream;
import java.util.List;

public class SettingsProvider {
    private final PrintStream out;

    public static final int MAX_ATTEMPTS = 7;

    private final InputSettingsProvider inputSettingsProvider;
    private final DictionaryLoader dictionaryLoader;
    RandomValueProvider randomValueProvider = new RandomValueProvider();

    public SettingsProvider(
        PrintStream out,
        InputSettingsProvider inputSettingsProvider,
        DictionaryLoader dictionaryLoader
    ) {
        this.out = out;
        this.inputSettingsProvider = inputSettingsProvider;
        this.dictionaryLoader = dictionaryLoader;
    }

    private String getCategory(List<String> categoriesList) {
        while (true) {
            String userInputCategory = inputSettingsProvider.getInputCategory(categoriesList);
            if (userInputCategory.isEmpty()) {
                return randomValueProvider.getRandomValue(categoriesList);
            } else if (categoriesList.contains(userInputCategory)) {
                return userInputCategory;
            } else {
                out.println("Неверная категория. Выберите из списка.");
            }
        }
    }

    private String getLevel(List<String> levelsList) {
        while (true) {
            String userInputLevel = inputSettingsProvider.getInputLevel(levelsList);
            if (userInputLevel.isEmpty()) {
                return randomValueProvider.getRandomValue(levelsList);
            } else if (levelsList.contains(userInputLevel)) {
                return userInputLevel;
            } else {
                out.println("Неверный уровень сложности. Выберите из списка.");
            }
        }
    }

    public String getWord() {
        List<String> categoriesList = dictionaryLoader.getCategoriesList();
        String category = getCategory(categoriesList);
        List<String> levelsList = dictionaryLoader.getLevelsList(category);
        String level = getLevel(levelsList);
        List<String> wordsList = dictionaryLoader.getWordsList(category, level);
        return randomValueProvider.getRandomValue(wordsList);
    }
}
