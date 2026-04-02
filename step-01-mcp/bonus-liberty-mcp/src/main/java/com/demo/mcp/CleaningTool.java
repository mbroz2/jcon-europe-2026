package com.demo.mcp;

import io.openliberty.mcp.annotations.Tool;
import io.openliberty.mcp.annotations.ToolArg;
import jakarta.enterprise.context.ApplicationScoped;

// --8<-- [start:libertyCleaningTool]
/**
 * Tool for requesting cleaning operations.
 */
@ApplicationScoped
public class CleaningTool {

    /**
     * Requests a cleaning based on the provided parameters.
     *
     * @param carNumber The car number
     * @param carMake The car make
     * @param carModel The car model
     * @param carYear The car year
     * @param exteriorWash Whether to request exterior wash
     * @param interiorCleaning Whether to request interior cleaning
     * @param detailing Whether to request detailing
     * @param waxing Whether to request waxing
     * @param requestText The cleaning request text
     * @return A summary of the cleaning request
     */
    @Tool(name = "requestCleaning", description = "Requests a cleaning with the specified options for a car")
    public String requestCleaning(
            @ToolArg(name = "carNumber", description = "The car number") int carNumber,
            @ToolArg(name = "carMake", description = "The car make") String carMake,
            @ToolArg(name = "carModel", description = "The car model") String carModel,
            @ToolArg(name = "carYear", description = "The car year") int carYear,
            @ToolArg(name = "exteriorWash", description = "Whether to request exterior wash") boolean exteriorWash,
            @ToolArg(name = "interiorCleaning", description = "Whether to request interior cleaning") boolean interiorCleaning,
            @ToolArg(name = "detailing", description = "Whether to request detailing") boolean detailing,
            @ToolArg(name = "waxing", description = "Whether to request waxing") boolean waxing,
            @ToolArg(name = "requestText", description = "Additional cleaning request notes") String requestText) {
        
        System.out.println("Liberty MCP Server: requestCleaning Tool called. ");
        
        // In a real implementation, this would make an API call to a cleaning service
        // or update a database with the cleaning request
        
        var result = generateCleaningSummary(carNumber, carMake, carModel, carYear,
                                              exteriorWash, interiorCleaning, detailing,
                                              waxing, requestText);
        
        System.out.println("\uD83D\uDE97 CleaningTool result: " + result);
        
        return result;
    }
    // --8<-- [end:libertyCleaningTool]

    private String generateCleaningSummary(
            int carNumber,
            String carMake,
            String carModel,
            int carYear,
            boolean exteriorWash,
            boolean interiorCleaning,
            boolean detailing,
            boolean waxing,
            String requestText) {

        var summary = new StringBuilder();
        summary.append("Cleaning requested for ").append(carMake).append(" ")
               .append(carModel).append(" (").append(carYear).append("), Car #")
               .append(carNumber).append(":\n");
        
        if (exteriorWash) {
            summary.append("- Exterior wash\n");
        }
        
        if (interiorCleaning) {
            summary.append("- Interior cleaning\n");
        }
        
        if (detailing) {
            summary.append("- Detailing\n");
        }
        
        if (waxing) {
            summary.append("- Waxing\n");
        }
        
        if (requestText != null && !requestText.isEmpty()) {
            summary.append("Additional notes: ").append(requestText);
        }
        
        return summary.toString();
    }
}