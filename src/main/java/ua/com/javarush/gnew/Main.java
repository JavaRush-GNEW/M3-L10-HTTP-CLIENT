package ua.com.javarush.gnew;

import ua.com.javarush.gnew.model.pet.Pet;
import ua.com.javarush.gnew.repository.PetRepository;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        PetRepository repository = new PetRepository();
//
//        String[] photoUrls = {"https://images.pexels.com/photos/2071882/pexels-photo-2071882.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"};
//
//        Pet pet = new Pet();
//
//        pet.setId(1231231231L);
//        pet.setName("JavaRush");
//        pet.setStatus("happy");
//        pet.setPhotoUrls(photoUrls);
//        repository.save(pet);

        Optional<Pet> optionalPet = repository.findById(123123145124123L);

//        Pet pet = optionalPet.orElseGet(null);

        if (optionalPet.isPresent()){
            Pet pet = optionalPet.get();
            System.out.println(pet);
        } else {
            System.out.println("Can't find");
        }




//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        /*
//
//         */
//
//        String requestBody = "        {\n" +
//                "          \"id\": 3546,\n" +
//                "          \"name\": \"JavaRush\",\n" +
//                "          \"category\": {\n" +
//                "            \"id\": 1,\n" +
//                "            \"name\": \"Dogs\"\n" +
//                "          },\n" +
//                "          \"photoUrls\": [\n" +
//                "            \"string\"\n" +
//                "          ],\n" +
//                "          \"tags\": [\n" +
//                "            {\n" +
//                "              \"id\": 0,\n" +
//                "              \"name\": \"string\"\n" +
//                "            }\n" +
//                "          ],\n" +
//                "          \"status\": \"available\"\n" +
//                "        }";
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://petstore3.swagger.io/api/v3/pet"))
//                .header("accept", "application/json")
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        try {
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//            System.out.println("Status code: " + response.statusCode());
//            System.out.println("Response body: ");
//            System.out.println(response.body());
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}