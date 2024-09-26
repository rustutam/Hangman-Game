package backend.academy.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AppTest {

    private App app;
    private SettingsProvider settingsProviderMock;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        settingsProviderMock = mock(SettingsProvider.class);
        gameMock = mock(Game.class);

        app = new App(settingsProviderMock, gameMock);
    }

    @Test
    void testStart() {
        String testWord = "test";

        when(settingsProviderMock.getWord()).thenReturn(testWord);
        doNothing().when(gameMock).start(testWord, SettingsProvider.MAX_ATTEMPTS);

        app.start();

        verify(settingsProviderMock).getWord();
        verify(gameMock).start(testWord, SettingsProvider.MAX_ATTEMPTS);
    }
}
