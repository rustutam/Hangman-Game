package backend.academy.Game;

import java.util.List;
import java.util.Random;

public class RandomValueProvider {
    private final List<String> words;
    private final Random random = new Random();

    public RandomValueProvider(List<String> wordsList) {
        this.words = wordsList;
    }

    public String getRandomValue() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
