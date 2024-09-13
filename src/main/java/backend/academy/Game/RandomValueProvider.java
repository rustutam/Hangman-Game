package backend.academy.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValueProvider {
    private final List<String> words;
    private final Random random;

    public RandomValueProvider(List<String> wordsList) {
        this.words = wordsList;
        this.random = new Random();
    }

    public String getRandomValue() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
