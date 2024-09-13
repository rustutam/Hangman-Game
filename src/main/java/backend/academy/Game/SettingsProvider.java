package backend.academy.Game;

import java.util.List;

public class SettingsProvider {
    private final int MAX_ATTEMPTS = 7;
    private String word;

    private String dictionaryPath = "src/main/java/backend/academy/Game/dictionary.json";

    private ConsoleInputProvider userInput = new ConsoleInputProvider();
    private DictionaryLoader loader = new DictionaryLoader(dictionaryPath);
    private List<String> categories = loader.getCategories();
    private List<String> levels = loader.getLevel();

    private String getCategory() {
        while (true) {
            String userInputCategory = userInput.getInputCategory(categories);
            if (categories.contains(userInputCategory)) {
                return userInputCategory;
            } else {
                System.out.println("Неверная категория. Выберите из списка.");
            }
        }
    }

    private String getLevel() {
        while (true) {
            String userInputLevel = userInput.getInputLevel(levels);
            if (categories.contains(userInputLevel)) {
                return userInputLevel;
            } else {
                System.out.println("Неверная категория. Выберите из списка.");
            }
        }
    }

    public String getWord() {
        String category = getCategory();
        String level = getLevel();
        word = loader.getRandomWord(category, level);
        return word;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }
}
