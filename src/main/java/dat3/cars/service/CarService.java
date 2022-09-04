package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarService {
    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getCars() {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = cars.stream().map(car -> new CarResponse(car, false)).collect(Collectors.toList());

        return response;
    }

    public CarResponse addCar(CarRequest carRequest, boolean includeAll) {
        Car newCar = CarRequest.getCarEntity(carRequest);
        newCar = carRepository.save(newCar);

        return new CarResponse(newCar, includeAll);
    }

    public void editCar(CarRequest body, int id){
        Car car = carRepository.findById(id).orElseThrow(()->  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car with this id already exist"));
        if(!body.getId().equals(id)){;
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change username");
        }
        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePrDay(body.getPricePrDay());
        car.setBestDiscount(body.getBestDiscount());
        carRepository.save(car);
    }

    public CarResponse findCarById(@PathVariable Integer id) throws Exception {
        Car found = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
        return new CarResponse(found,false);
    }

    public void setPricePrDay(int carId, double price) {
        Car car = carRepository.findById(carId).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this id does not exist"));
        car.setPricePrDay(price);
        carRepository.save(car);
    }

    public void deleteById(int id) {
        carRepository.existsById(id);
    }
}
