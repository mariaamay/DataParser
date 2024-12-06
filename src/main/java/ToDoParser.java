import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ToDoParser {
    public static void ToDoParse() {
        try {
            URL url = new URL("https://dummy-json.mock.beeceptor.com/todos");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream responseStream = connection.getInputStream();
            JsonReader jsonReader = Json.createReader(responseStream);
            JsonArray jsonArray = jsonReader.readArray();
            jsonReader.close();

            for (int i = 0; i < jsonArray.size(); i++) {

                JsonObject jsonObject = jsonArray.getJsonObject(i);

                int userId = jsonObject.getInt("userId", -1);
                int id = jsonObject.getInt("id", -1);
                String title = jsonObject.getString("title", "none");
                boolean completed = jsonObject.containsKey("completed") && jsonObject.getBoolean("completed");

                System.out.println("userID: " + (userId != -1 ? userId : "none"));
                System.out.println("ID: " + (id != -1 ? id : "none"));
                System.out.println("Title: " + title);
                System.out.println("Completed: " + completed);
                System.out.println("----------------------");
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        System.out.println("\n");
    }
}
