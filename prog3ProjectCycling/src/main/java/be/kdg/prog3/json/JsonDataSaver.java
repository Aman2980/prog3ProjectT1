package be.kdg.prog3.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonDataSaver {

    public static void saveDataToJson(String fileName, List<?> data) {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            String jsonString = gson.toJson(data);

            // Specify the correct relative path
            FileWriter fileWriter = new FileWriter("src/main/java/be/kdg/prog3/resources/" + fileName, false);
            fileWriter.write(jsonString);
            fileWriter.close();

            System.out.println("Data saved to " + fileName + " in src/main/java/be/kdg/prog3/resources/...");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save data to " + fileName + " in src/main/java/be/kdg/prog3/resources/...");
        }
    }
}

