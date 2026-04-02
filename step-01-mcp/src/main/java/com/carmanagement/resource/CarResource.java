package com.carmanagement.resource;

import com.carmanagement.model.CarInfo;
import com.carmanagement.repository.CarInfoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * REST resource for car operations.
 */
@Path("/cars")
public class CarResource {
    
    @Inject
    CarInfoRepository repository;
        
    /**
     * Get all cars in the system.
     * 
     * @return List of all cars
     */
    @GET
    public List<CarInfo> getAllCars() {
        return repository.listAll();
    }
    
    /**
     * Get a specific car by its ID.
     * 
     * @param id The car ID
     * @return The car with the specified ID, or 404 if not found
     */
    @GET
    @Path("/{id}")
    public Response getCarById(Long id) {
        CarInfo car = repository.findById(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Car with ID " + id + " not found")
                    .build();
        }
        return Response.ok(car).build();
    }
}

// Made with Bob
