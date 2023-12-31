package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class CarDTO {
        private String car_Id;

        private String name;
        private String brand;
        private String type;
        private String image;
        private int number_Of_Passengers;
        private String transmission_Type;
        private String fuel_Type;
        private int rent_Duration_Price;
        private double price_Extra_KM;
        private String registration_Number;
        private double free_Mileage;
        private String color;
        private String vehicleAvailabilityType;
    }


