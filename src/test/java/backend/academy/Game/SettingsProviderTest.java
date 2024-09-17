package backend.academy.Game;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SettingsProviderTest {
    private SettingsProvider settingsProvider;
    private InputSettingsProvider inputSettingsProvider;
    private DictionaryLoader dictionaryLoader;
    private RandomValueProvider randomValueProvider;
    private PrintStream out;

    @BeforeEach
    void setUp() throws Exception {
        out = mock(PrintStream.class);
        inputSettingsProvider = mock(InputSettingsProvider.class);
        dictionaryLoader = mock(DictionaryLoader.class);
        randomValueProvider = mock(RandomValueProvider.class);
        settingsProvider = new SettingsProvider(out, inputSettingsProvider, dictionaryLoader);

        Field field = SettingsProvider.class.getDeclaredField("randomValueProvider");
        field.setAccessible(true);
        field.set(settingsProvider, randomValueProvider);
    }

    @Test
    void testGetWord() {
        List<String> categories = Arrays.asList("ANIMALS", "COUNTRIES", "FRUITS");
        List<String> levels = Arrays.asList("EASY", "MEDIUM", "HARD");
        List<String> words = Arrays.asList("КИТАЙ", "РОССИЯ", "США");

        when(dictionaryLoader.getCategoriesList()).thenReturn(categories);
        when(inputSettingsProvider.getInputCategory(categories)).thenReturn("COUNTRIES");
        when(dictionaryLoader.getLevelsList("COUNTRIES")).thenReturn(levels);
        when(inputSettingsProvider.getInputLevel(levels)).thenReturn("MEDIUM");
        when(dictionaryLoader.getWordsList("COUNTRIES", "MEDIUM")).thenReturn(words);
        when(randomValueProvider.getRandomValue(words)).thenReturn("РОССИЯ");

        String word = settingsProvider.getWord();

        assertEquals("РОССИЯ", word);
    }

    @Test
    void testGetWordWithEmptyUserInput() {
        List<String> categories = Arrays.asList("ANIMALS", "COUNTRIES", "FRUITS");
        List<String> levels = Arrays.asList("EASY", "MEDIUM", "HARD");
        List<String> words = Arrays.asList("КИТАЙ", "РОССИЯ", "США");

        when(dictionaryLoader.getCategoriesList()).thenReturn(categories);
        when(inputSettingsProvider.getInputCategory(categories)).thenReturn("");
        when(randomValueProvider.getRandomValue(categories)).thenReturn("COUNTRIES");

        when(dictionaryLoader.getLevelsList("COUNTRIES")).thenReturn(levels);
        when(inputSettingsProvider.getInputLevel(levels)).thenReturn("");
        when(randomValueProvider.getRandomValue(levels)).thenReturn("HARD");

        when(dictionaryLoader.getWordsList("COUNTRIES", "HARD")).thenReturn(words);
        when(randomValueProvider.getRandomValue(words)).thenReturn("РОССИЯ");

        String word = settingsProvider.getWord();

        assertEquals("РОССИЯ", word);
    }

    @Test
    void testGetWordWithInvalidUserInput() {
        List<String> categories = Arrays.asList("ANIMALS", "COUNTRIES", "FRUITS");
        List<String> levels = Arrays.asList("EASY", "MEDIUM", "HARD");
        List<String> words = Arrays.asList("КИТАЙ", "РОССИЯ", "США");

        when(dictionaryLoader.getCategoriesList()).thenReturn(categories);
        when(inputSettingsProvider.getInputCategory(categories))
            .thenReturn("INVALID")
            .thenReturn("COUNTRIES");
        when(dictionaryLoader.getLevelsList("COUNTRIES")).thenReturn(levels);
        when(inputSettingsProvider.getInputLevel(levels))
            .thenReturn("INVALID")
            .thenReturn("MEDIUM");
        when(dictionaryLoader.getWordsList("COUNTRIES", "MEDIUM")).thenReturn(words);
        when(randomValueProvider.getRandomValue(words)).thenReturn("РОССИЯ");

        String word = settingsProvider.getWord();
        verify(out).println("Неверная категория. Выберите из списка.");
        verify(out).println("Неверный уровень сложности. Выберите из списка.");
        assertEquals("РОССИЯ", word);

    }
}
