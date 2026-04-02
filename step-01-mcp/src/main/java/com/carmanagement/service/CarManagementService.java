package com.carmanagement.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.carmanagement.agentic.agents.CleaningAgent;
import com.carmanagement.model.CarInfo;
import com.carmanagement.model.CarStatus;
import com.carmanagement.repository.CarInfoRepository;

/**
 * Service for managing car returns from various operations.
 */
@ApplicationScoped
public class CarManagementService {

    @Inject
    CleaningAgent cleaningAgent;
    
    @Inject
    CarInfoRepository repository;

    // --8<-- [start:processCarReturn]
    /**
     * Process a car return from any operation.
     *
     * @param carNumber The car number
     * @param rentalFeedback Optional rental feedback
     * @param cleaningFeedback Optional cleaning feedback
     * @return Result of the processing
     */
    public String processCarReturn(Integer carNumber, String rentalFeedback, String cleaningFeedback) {
        CarInfo carInfo = repository.findById(carNumber.longValue());
        if (carInfo == null) {
            return "Car not found with number: " + carNumber;
        }

        // Process the car result
        String result = cleaningAgent.processCleaning(
                carInfo.make,
                carInfo.model,
                carInfo.year,
                carNumber,
                rentalFeedback != null ? rentalFeedback : "",
                cleaningFeedback != null ? cleaningFeedback : "");

        // Update car status based on the cleaning result
        if (result.toUpperCase().contains("CLEANING_NOT_REQUIRED")) {
            carInfo.status = CarStatus.AVAILABLE;
            repository.persist(carInfo);
        } else if (result.toUpperCase().contains("CLEANING_REQUESTED")) {
            carInfo.status = CarStatus.AT_CLEANING;
            repository.persist(carInfo);
        }

        return result;
    }
    // --8<-- [end:processCarReturn]
}
