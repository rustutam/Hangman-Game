package backend.academy.Game;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DictionaryLoader {
    private static final String CATEGORIES = "categories";
    private JsonNode dictionary;

    public DictionaryLoader(String filePath, PrintStream out) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dictionary = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }

    public List<String> getCategoriesList() {
        List<String> categoriesList = new ArrayList<>();
        JsonNode categoriesNode = dictionary.path(CATEGORIES);
        Iterator<String> fieldNames = categoriesNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            categoriesList.add(fieldName);
        }
        return categoriesList;
    }

    public List<String> getLevelsList(String category) {
        List<String> levelList = new ArrayList<>();
        JsonNode levelNode = dictionary.path(CATEGORIES).path(category);
        Iterator<String> fieldNames = levelNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            levelList.add(fieldName);
        }
        return levelList;
    }

    public List<String> getWordsList(String category, String level) {
        List<String> words = new ArrayList<>();
        JsonNode wordsNode = dictionary.path(CATEGORIES).path(category).path(level);
        if (wordsNode.isArray()) {
            for (JsonNode wordNode : wordsNode) {
                words.add(wordNode.asText());
            }
        }
        return words;
    }
}
