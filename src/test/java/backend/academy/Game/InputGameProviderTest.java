package backend.academy.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class InputGameProviderTest {

    private InputProvider inputProviderMock;
    private InputGameProvider inputGameProvider;

    @BeforeEach
    void setUp() {
        inputProviderMock = mock(InputProvider.class);
        inputGameProvider = new InputGameProvider(inputProviderMock);
    }

    @Test
    void testGetInputSymbol() {
        when(inputProviderMock.getInput("Введите букву:")).thenReturn("A");

        String inputSymbol = inputGameProvider.getInputSymbol();

        assertEquals("A", inputSymbol);
        verify(inputProviderMock).getInput("Введите букву:");
    }
}

