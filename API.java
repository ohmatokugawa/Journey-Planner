import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;

public class API {

    public static double waluty(String kodWaluty) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + kodWaluty + "/?format=json";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        JSONArray rates = json.getJSONArray("rates");
        double mid = rates.getJSONObject(0).getDouble("mid");

        return mid;
    }
}
