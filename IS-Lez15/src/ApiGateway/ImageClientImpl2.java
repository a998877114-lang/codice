package ApiGateway;

import java.io.IOError;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImageClientImpl2 implements ImageClient {
    @Override
    public String getImagePath() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpGet = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8080/images")).build();
        try {
            HttpResponse httpResponse = httpClient.send(httpGet, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
