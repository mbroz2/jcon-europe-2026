package com.carmanagement.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.carmanagement.agentic.workflow.CarProcessingWorkflow;
import com.carmanagement.model.CarConditions;
import com.carmanagement.repository.CarInfoRepository;
import com.carmanagement.model.CarInfo;
import com.carmanagement.model.CarStatus;

/**
 * Service for managing car returns from various operations.
 */
@ApplicationScoped
public class CarManagementService {
    @Inject
    CarInfoRepository repository;

    @Inject
    CarProcessingWorkflow carProcessingWorkflow;

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

        // Process the car return using the workflow and get the AgenticScope
        CarConditions carConditions = carProcessingWorkflow.processCarReturn(
                carInfo.make,
                carInfo.model,
                carInfo.year,
                carNumber,
                carInfo.condition,
                rentalFeedback != null ? rentalFeedback : "",
                cleaningFeedback != null ? cleaningFeedback : "");

        // Update the car's condition with the result from CarConditionFeedbackAgent
        carInfo.condition = carConditions.generalCondition();

        // If cleaning was not required, make the car available to rent
        if (!carConditions.cleaningRequired()) {
            carInfo.status = CarStatus.AVAILABLE;            
        }
        
        repository.persist(carInfo);

        return carConditions.generalCondition();
    }
}
