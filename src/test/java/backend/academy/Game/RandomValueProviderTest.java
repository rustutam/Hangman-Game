package backend.academy.Game;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomValueProviderTest {

    @Test
    void testGetRandomValue() {
        RandomValueProvider randomValueProvider = new RandomValueProvider();
        List<String> wordsList = Arrays.asList("КИТАЙ", "РОССИЯ", "США");

        String randomValue = randomValueProvider.getRandomValue(wordsList);

        assertTrue(wordsList.contains(randomValue));
    }
}
