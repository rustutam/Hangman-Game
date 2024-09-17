package backend.academy.Game;

import java.security.SecureRandom;
import java.util.List;

public class RandomValueProvider {
    private final List<String> words;
    private final SecureRandom random = new SecureRandom();

    public RandomValueProvider(List<String> wordsList) {
        this.words = wordsList;
    }

    public String getRandomValue() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
