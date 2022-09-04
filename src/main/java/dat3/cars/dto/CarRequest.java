package dat3.cars.dto;

import dat3.cars.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CarRequest {
    Integer id;

    String brand;

    String model;

    double pricePrDay;

    double bestDiscount;

    public CarRequest(String brand, String model, double pricePrDay, double bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public CarRequest(Car car) {
    }

    public static Car getCarEntity(CarRequest c) {
        return new Car(c.getBrand(), c.getModel(), c.getPricePrDay(), c.getBestDiscount());
    }

}
