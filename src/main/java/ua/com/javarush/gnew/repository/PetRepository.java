package ua.com.javarush.gnew.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.com.javarush.gnew.model.pet.Pet;

public class PetRepository {

    private static final String BASE_URL = "https://petstore3.swagger.io/api/v3";

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();


    public void save(Pet pet){
        String endpoint = "/pet";
        String httpMethod = "POST";
        String requestBody = getJson(pet);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .method(httpMethod, HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response body: ");
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<Pet> findById(long id){
        String endpoint = "/pet/" + id;
        String httpMethod = "GET";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .method(httpMethod, HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200){
                return Optional.ofNullable(objectMapper.readValue(response.body(), Pet.class));
            } else {
                return Optional.empty();
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private String getJson(Pet pet) {
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(pet);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return requestBody;
    }


}
