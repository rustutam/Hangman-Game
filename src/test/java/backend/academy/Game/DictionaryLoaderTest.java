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
        dictionaryLoader = new DictionaryLoader("Game/dictionary.json", System.out);
        List<String> categories = Arrays.asList("ANIMALS", "FRUITS", "COUNTRIES");
        List<String> categoriesInFile = dictionaryLoader.getCategoriesList();

        assertEquals(categories, categoriesInFile);

    }

    @Test
    public void testGetLevelsList() {
        dictionaryLoader = new DictionaryLoader("Game/dictionary.json", System.out);
        List<String> levels = Arrays.asList("EASY", "MEDIUM", "HARD");
        String category = "ANIMALS";
        List<String> levelsInFile = dictionaryLoader.getLevelsList(category);

        assertEquals(levels, levelsInFile);

    }

    @Test
    public void testGetWordsList() {
        dictionaryLoader = new DictionaryLoader("Game/dictionary.json", System.out);
        List<String> words = Arrays.asList("КОТ", "ПЁС", "КОРОВА");
        String category = "ANIMALS";
        String level = "EASY";

        List<String> wordsInFile = dictionaryLoader.getWordsList(category, level);

        assertEquals(words, wordsInFile);
    }

    @Test
    public void testFileNotFound() {
        new DictionaryLoader("wrong_path.json", System.out);
        assertTrue(outContent.toString().contains("Файл не существует"));
    }

    @Test
    public void testInvalidPath() {
        new DictionaryLoader("../../unauthorized.json", System.out);
        assertTrue(outContent.toString().contains("Недопустимый путь."));
    }
}
