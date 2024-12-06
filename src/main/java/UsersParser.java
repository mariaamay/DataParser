import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UsersParser {
    public static void UsersParse() {
        try {
            URL url = new URL("https://fake-json-api.mock.beeceptor.com/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream responseStream = connection.getInputStream();
            JsonReader jsonReader = Json.createReader(responseStream);
            JsonArray jsonArray = jsonReader.readArray();
            jsonReader.close();

            for (int i = 0; i < jsonArray.size(); i++) {

                JsonObject jsonObject = jsonArray.getJsonObject(i);

                int id = jsonObject.getInt("id", -1);
                String name = jsonObject.getString("name", "none");
                String company = jsonObject.getString("company", "none");
                String username = jsonObject.getString("username", "none");
                String email = jsonObject.getString("email", "none");
                String address = jsonObject.getString("address", "none");
                String zip = jsonObject.getString("zip", "none");
                String state = jsonObject.getString("state", "none");
                String country = jsonObject.getString("country", "none");
                String phone = jsonObject.getString("phone", "none");
                String photo = jsonObject.getString("photo", "none");


                System.out.println("ID: " + (id != -1 ? id : "none"));
                System.out.println("Name: " + name);
                System.out.println("Company: " + company);
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
                System.out.println("Address: " + address);
                System.out.println("Zip: " + zip);
                System.out.println("State: " + state);
                System.out.println("Country: " + country);
                System.out.println("Phone: " + phone);
                System.out.println("Photo: " + photo);
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
