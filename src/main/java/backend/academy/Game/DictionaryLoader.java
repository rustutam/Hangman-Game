package backend.academy.Game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DictionaryLoader {
    private JsonNode rootNode;

    public DictionaryLoader(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            rootNode = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getCategories() {
        List<String> categoriesList = new ArrayList<>();
        JsonNode categoriesNode = rootNode.path("categories");
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
        JsonNode levelNode = rootNode.path("categories").path(categoriesList.getFirst());
        Iterator<String> fieldNames = levelNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            levelList.add(fieldName);
        }
        return levelList;
    }



    public static void main(String[] args) {

        String dictionaryPath = "src/main/java/backend/academy/Game/dictionary.json";
        DictionaryLoader loader = new DictionaryLoader(dictionaryPath);
        List<String> categories = loader.getCategories();
        List<String> levels = loader.getLevel();

        System.out.println(categories);
        System.out.println(levels);
    }
}
