package dat3.cars.api;


import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Security Admin
    //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    // same as above when you are using @RestController
    public CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body, true);
    }


    // Security Admin
    @GetMapping()
    public List<CarResponse> getCars() {
        return carService.getCars();
    }

    //Security Admin
    @GetMapping(path = "/{id}")
    public CarResponse getCarById(@PathVariable Integer id) throws Exception {
        return carService.findCarById(id);
    }


    // Security Admin
    @PutMapping("/{id}")
    ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable Integer id){
        carService.editCar(body, id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // Security Admin
    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable Integer id) {
        carService.deleteById(id);
    }

}
