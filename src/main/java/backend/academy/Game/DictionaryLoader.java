package backend.academy.Game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DictionaryLoader {
    private static final String CATEGORIES = "categories";
    private JsonNode dictionary;

    public DictionaryLoader(String filePath, PrintStream out) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Path basePath = Paths.get("src/main/java/backend/academy");
            Path fileToRead = basePath.resolve(filePath).normalize();

            if (!fileToRead.startsWith(basePath)) {
                throw new SecurityException("Недопустимый путь.");
            }

            if (Files.exists(fileToRead)) {
                dictionary = objectMapper.readTree(fileToRead.toFile());
            } else {
                throw new IOException("Файл не существует.");
            }
        } catch (IOException | SecurityException | InvalidPathException e) {
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

    public String getHint(String word) {
        return dictionary.path("hints").path(word).asText();
    }
}
