package fetcher.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static fetcher.common.Constants.URL;

public class HttpManager {

    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public HttpManager() {
        this.buildHttpClient();
        this.buildHttpRequest();
    }

    private void buildHttpClient() {
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    private void buildHttpRequest() {
        this.request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .setHeader("Content-Type", "application/json")
                .setHeader("charset", "UTF-8")
                .build();
    }

    public HttpResponse<String> sendHttpRequest() throws IOException, InterruptedException {
        return this.client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
