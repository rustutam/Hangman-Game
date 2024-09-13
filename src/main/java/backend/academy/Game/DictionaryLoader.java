package backend.academy.Game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DictionaryLoader {
    private JsonNode dictionary;

    public DictionaryLoader(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dictionary = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<String> getCategories() {
        List<String> categoriesList = new ArrayList<>();
        JsonNode categoriesNode = dictionary.path("categories");
        Iterator<String> fieldNames = categoriesNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            categoriesList.add(fieldName);
        }
        return categoriesList;
    }

    public List<String> getLevel(){
        List<String> categoriesList = getCategories();
        List<String> levelList = new ArrayList<>();
        JsonNode levelNode = dictionary.path("categories").path(categoriesList.getFirst());
        Iterator<String> fieldNames = levelNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            levelList.add(fieldName);
        }
        return levelList;
    }

    public String getRandomWord(String category, String level){
        List<String> words = new ArrayList<>();
        JsonNode wordsNode = dictionary.path("categories").path(category).path(level);
        if (wordsNode.isArray()) {
            for (JsonNode wordNode : wordsNode) {
                words.add(wordNode.asText());
            }
        }
        RandomValueProvider random = new RandomValueProvider(words);
        return random.getRandomValue();
    }





    public static void main(String[] args) {

        String dictionaryPath = "src/main/java/backend/academy/Game/dictionary.json";
        DictionaryLoader loader = new DictionaryLoader(dictionaryPath);
        List<String> categories = loader.getCategories();
        List<String> levels = loader.getLevel();

        System.out.println(categories);
        System.out.println(levels);
        System.out.println(loader.getRandomWord("animals", "easy"));
    }
}
