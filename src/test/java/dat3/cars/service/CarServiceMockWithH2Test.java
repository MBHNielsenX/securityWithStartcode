package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CarServiceMockWithH2Test {

    public CarService carService;
    public static CarRepository carRepository;

    static  int car1Id, car2Id;

    @BeforeAll
    public static void initTestData(@Autowired CarRepository car_Repository) {
        carRepository = car_Repository;
        carRepository.deleteAll();
        Car car1= new Car("MC", "Mercedes", 500, 30);
        Car car2= new Car("Ford", "Fiesta", 500, 20);
        car1 = carRepository.save(car1);
        car2 = carRepository.save(car2);


        car1Id = car1.getId();
        car2Id = car2.getId();
        carRepository = car_Repository;
    }

    @BeforeEach
    public void initCarService() {carService = new CarService(carRepository);}

    @Test
    void getCars() {
        List<CarResponse> cars = carService.getCars();
        assertEquals(2, cars.size());
        //assertNull(cars.get(0).getBestDiscount());
    }

    @Test
    void addCar() {
        CarRequest request = new CarRequest("Mazda", "5", 300, 34);
        CarResponse response = carService.addCar(request, true);
        assertTrue(response.getId() > 0);
        assertTrue(response.getCreated().isBefore(LocalDateTime.now()));
    }

    /*
    @Test
    void editCar() {
        Car carToEdit = carRepository.findById(car1Id).get();
        LocalDateTime previousEdit = carToEdit.getEdited();
        carToEdit.setPricePrDay(1200);
        carToEdit.setBestDiscount(80);
        CarRequest request = new CarRequest(carToEdit);
        carService.editCar(request,car1Id);
        Car edited = carRepository.findById(car1Id).get();
        assertEquals(1200, edited.getPricePrDay());
        assertEquals(80, edited.getBestDiscount());
        assertTrue(edited.getEdited().isBefore(LocalDateTime.now()));
    }

     */

    @Test
    void findCarById() throws Exception {
        CarResponse response = carService.findCarById(car1Id);
        assertEquals(car1Id, response.getId());
    }

    @Test
    void setPricePrDay() throws Exception {
        carService.setPricePrDay(car1Id, 111);
        CarResponse response = carService.findCarById(car1Id);
        assertEquals(111, response.getPricePrDay());
    }

}