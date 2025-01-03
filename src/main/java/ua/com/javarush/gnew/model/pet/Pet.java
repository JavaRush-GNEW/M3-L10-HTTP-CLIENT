package ua.com.javarush.gnew.model.pet;

import lombok.Data;

@Data
public class Pet {
    private Long id;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;
}
