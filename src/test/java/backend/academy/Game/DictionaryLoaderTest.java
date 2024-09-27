package backend.academy.Game;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DictionaryLoaderTest {
    private DictionaryLoader dictionaryLoader;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGetCategoriesList() {
        // Arrange
        dictionaryLoader = new DictionaryLoader("Game/dictionary.json", System.out);
        List<String> categories = Arrays.asList("ANIMALS", "FRUITS", "COUNTRIES");

        // Act
        List<String> categoriesInFile = dictionaryLoader.getCategoriesList();

        // Assert
        assertEquals(categories, categoriesInFile);

    }

    @Test
    public void testGetLevelsList() {
        // Arrange
        dictionaryLoader = new DictionaryLoader("Game/dictionary.json", System.out);
        List<String> levels = Arrays.asList("EASY", "MEDIUM", "HARD");
        String category = "ANIMALS";

        // Act
        List<String> levelsInFile = dictionaryLoader.getLevelsList(category);

        // Assert
        assertEquals(levels, levelsInFile);

    }

    @Test
    public void testGetWordsList() {
        // Arrange
        dictionaryLoader = new DictionaryLoader("Game/dictionary.json", System.out);
        List<String> words = Arrays.asList("КОТ", "ПЁС", "КОРОВА");
        String category = "ANIMALS";
        String level = "EASY";

        // Act
        List<String> wordsInFile = dictionaryLoader.getWordsList(category, level);

        // Assert
        assertEquals(words, wordsInFile);
    }

    @Test
    public void testGetHint() {
        // Arrange
        dictionaryLoader = new DictionaryLoader("Game/dictionary.json", System.out);
        String hint = "Домашнее животное, мурлыкает";
        String word = "КОТ";

        // Act
        String hintInFile = dictionaryLoader.getHint(word);

        // Assert
        assertEquals(hint, hintInFile);
    }

    @Test
    public void testFileNotFound() {
        // Arrange
        String filePath = "wrong_path.json";

        // Act
        new DictionaryLoader(filePath, System.out);

        // Assert
        assertTrue(outContent.toString().contains("Файл не существует"));
    }

    @Test
    public void testInvalidPath() {
        // Arrange
        String invalidFilePath = "../../unauthorized.json";

        // Act
        new DictionaryLoader(invalidFilePath, System.out);

        //Assert
        assertTrue(outContent.toString().contains("Недопустимый путь."));
    }
}
