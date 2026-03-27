package com.carmanagement.repository;

import com.carmanagement.model.CarInfo;
import com.carmanagement.repository.CarInfoRepository;
import com.carmanagement.model.CarStatus;
import com.carmanagement.repository.CarInfoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * In-memory repository for CarInfo entities.
 */
@ApplicationScoped
public class CarInfoRepository {
    
    private final Map<Long, CarInfo> cars = new ConcurrentHashMap<>();
    
    @PostConstruct
    void init() {
        // Initialize with sample data
        int currentYear = Year.now().getValue();
        
        add(new CarInfo("Mercedes-Benz", "C-Class", currentYear - 2, CarStatus.RENTED));
        add(new CarInfo("BMW", "X5", currentYear - 1, CarStatus.AT_CLEANING));
        add(new CarInfo("Audi", "Q4", currentYear - 1, CarStatus.RENTED));
        add(new CarInfo("Nissan", "Altima", currentYear - 8, CarStatus.AT_CLEANING));
        add(new CarInfo("Ford", "Focus", currentYear - 12, CarStatus.RENTED));
        add(new CarInfo("Toyota", "Corolla", currentYear - 3, CarStatus.RENTED));
        add(new CarInfo("Honda", "Civic", currentYear - 4, CarStatus.RENTED));
        add(new CarInfo("Ford", "F-150", currentYear - 2, CarStatus.AT_CLEANING));
    }
    
    public CarInfo add(CarInfo car) {
        cars.put(car.id, car);
        return car;
    }
    
    public CarInfo findById(Long id) {
        return cars.get(id);
    }
    
    public List<CarInfo> listAll() {
        return cars.values().stream()
                .sorted((a, b) -> Long.compare(a.id, b.id))
                .collect(Collectors.toList());
    }
    
    public List<CarInfo> findByStatus(CarStatus status) {
        return cars.values().stream()
                .filter(car -> car.status == status)
                .sorted((a, b) -> Long.compare(a.id, b.id))
                .collect(Collectors.toList());
    }
    
    public void persist(CarInfo car) {
        cars.put(car.id, car);
    }
    
    public long count() {
        return cars.size();
    }
}

// Made with Bob
