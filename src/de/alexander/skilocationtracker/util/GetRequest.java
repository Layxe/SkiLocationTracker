package de.alexander.skilocationtracker.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * GetRequest
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public class GetRequest {

    // Variables
    // #################################################################################################

    private HttpResponse<String> response;

    /**
     * Create a new get request
     * @param address address the request will be send to
     */

    // Constructor
    // #################################################################################################

    public GetRequest(String address) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("There has been an error with the request: ");
            e.printStackTrace();
        }

    }

    // Getter
    // #################################################################################################

    /**
     * Get the response body of the request
     * @return String response body
     */

    public String getBody() {
        return response.body();
    }

}
