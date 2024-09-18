package backend.academy.Game;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class InputSettingsProviderTest {

    private InputProvider inputProviderMock;
    private InputSettingsProvider inputSettingsProvider;

    @BeforeEach
    void setUp() {
        inputProviderMock = mock(InputProvider.class);
        inputSettingsProvider = new InputSettingsProvider(inputProviderMock);
    }

    @Test
    void testGetInputCategory() {
        List<String> categories = Arrays.asList("ANIMALS", "COUNTRIES", "FRUITS");
        when(inputProviderMock.getInput("Выберите категорию:" + categories)).thenReturn("COUNTRIES");

        String category = inputSettingsProvider.getInputCategory(categories);

        assertEquals("COUNTRIES", category);
        verify(inputProviderMock).getInput("Выберите категорию:" + categories);
    }

    @Test
    void testGetInputLevel() {
        List<String> levels = Arrays.asList("EASY", "MEDIUM", "HARD");
        when(inputProviderMock.getInput("Выберите уровень сложности:" + levels)).thenReturn("MEDIUM");

        String level = inputSettingsProvider.getInputLevel(levels);

        assertEquals("MEDIUM", level);
        verify(inputProviderMock).getInput("Выберите уровень сложности:" + levels);
    }
}
