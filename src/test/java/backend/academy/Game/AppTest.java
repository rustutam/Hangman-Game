package backend.academy.Game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AppTest {

    private App app;
    private SettingsProvider settingsProviderMock;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        InputStream in = new ByteArrayInputStream("".getBytes());
        PrintStream out = new PrintStream(new ByteArrayOutputStream());

        settingsProviderMock = mock(SettingsProvider.class);
        gameMock = mock(Game.class);

        app = new App(in, out);
        app.settingsProvider = settingsProviderMock;
        app.game = gameMock;
    }

    @Test
    void testStart() {
        String testWord = "test";
        int maxAttempts = SettingsProvider.MAX_ATTEMPTS;

        when(settingsProviderMock.getWord()).thenReturn(testWord);

        app.start();

        verify(settingsProviderMock).getWord();
        verify(gameMock).start(testWord, maxAttempts);
    }
}
