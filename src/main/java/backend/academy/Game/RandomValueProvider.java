package backend.academy.Game;

import java.security.SecureRandom;
import java.util.List;

public class RandomValueProvider {
    private final SecureRandom random = new SecureRandom();

    public String getRandomValue(List<String> wordsList) {
        int index = random.nextInt(wordsList.size());
        return wordsList.get(index);
    }
}
