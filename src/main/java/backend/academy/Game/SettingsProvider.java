package backend.academy.Game;

import java.util.List;

public class SettingsProvider {
    public final int MAX_ATTEMPTS = 7;

    private final List<String> categories;
    private List<String> levels;

    private final InputSettingsProvider inputSettingsProvider;
    private final DictionaryLoader dictionaryLoader;

    public SettingsProvider(
        InputSettingsProvider inputSettingsProvider,
        DictionaryLoader dictionaryLoader
    ) {
        this.inputSettingsProvider = inputSettingsProvider;
        this.dictionaryLoader = dictionaryLoader;
        categories = dictionaryLoader.getCategoriesList();
    }

    private String getCategory() {
        while (true) {
            String userInputCategory = inputSettingsProvider.getInputCategory(categories);
            if (categories.contains(userInputCategory)) {
                return userInputCategory;
            } else {
                System.out.println("Неверная категория. Выберите из списка.");
            }
        }
    }

    private String getLevel() {
        while (true) {
            String userInputLevel = inputSettingsProvider.getInputLevel(levels);
            if (levels.contains(userInputLevel)) {
                return userInputLevel;
            } else {
                System.out.println("Неверный уровень сложности. Выберите из списка.");
            }
        }
    }

    public String getWord() {
        String category = getCategory();
        levels = dictionaryLoader.getLevelsList(category);
        String level = getLevel();
        List<String> wordsList = dictionaryLoader.getWordsList(category, level);
        RandomValueProvider randomValueProvider = new RandomValueProvider(wordsList);
        return randomValueProvider.getRandomValue();
    }
}
