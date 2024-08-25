package ku.cs.restaurant.service;

import ku.cs.restaurant.entity.Restaurant;
import ku.cs.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
 * Thanawat Potidet
 * 6510450445
 * */
@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getRestaurant(){
        return repository.findAll();

    }

   public Restaurant getRestaurantById(UUID id){
        return repository.findById(id).get();
   }

    public Restaurant create(Restaurant restaurant){
        Restaurant newRestaurant = repository.save(restaurant);
        return newRestaurant;
    }

    public Restaurant update(Restaurant requestBody){
       UUID id = requestBody.getId();
       Restaurant restaurant = repository.findById(id).get();
       restaurant.setName(requestBody.getName());
       restaurant.setLocation(requestBody.getLocation());
       restaurant.setRating(requestBody.getRating());

        repository.save(restaurant);
       return restaurant;
    }

    public Restaurant delete(UUID id) {
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }

    public Restaurant getRestaurantByName(String name) {
        return repository.findByName(name);
    }


    public List<Restaurant> getRestaurantByLocation(String location) {
        return repository.findByLocation(location);
    }

}
