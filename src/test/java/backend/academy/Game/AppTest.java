package backend.academy.Game;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AppTest {

    @Test
    void testStart() {
        // Arrange
        SettingsProvider settingsProviderMock = mock(SettingsProvider.class);
        Game gameMock = mock(Game.class);
        App app = new App(settingsProviderMock, gameMock);
        String testWord = "test";
        String hint = "hint";
        when(settingsProviderMock.getWord()).thenReturn(testWord);
        when(settingsProviderMock.getHint(testWord)).thenReturn(hint);
        doNothing().when(gameMock).start(testWord, SettingsProvider.MAX_ATTEMPTS, hint);

        // Act
        app.start();

        // Assert
        verify(settingsProviderMock).getWord();
        verify(settingsProviderMock).getHint(testWord);
        verify(gameMock).start(testWord, SettingsProvider.MAX_ATTEMPTS, hint);
    }
}
