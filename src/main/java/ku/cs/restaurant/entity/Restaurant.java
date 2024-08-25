package ku.cs.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

/*
 * Thanawat Potidet
 * 6510450445
 * */
@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private double rating;
    private String location;
}
