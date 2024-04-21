package constat.mobile.dev.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import constat.mobile.dev.Entitys.Car;
import constat.mobile.dev.Services.VehicleService;

@RestController
@RequestMapping("/api/Cars")
public class CarController {

    @Autowired
    private VehicleService CarService;

    // Endpoint pour récupérer tous les véhicules
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> Cars = CarService.getAllCars();
        return new ResponseEntity<>(Cars, HttpStatus.OK);
    }

    // Endpoint pour récupérer un véhicule par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") String id) {
        Car Car = CarService.getCarById(id);
        if (Car != null) {
            return new ResponseEntity<>(Car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour ajouter un nouveau véhicule
    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car Car) {
        Car newCar = CarService.addCar(Car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un véhicule existant
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") String id, @RequestBody Car Car) {
        Car updatedCar = CarService.updateCar(id, Car);
        if (updatedCar != null) {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un véhicule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") String id) {
        boolean deleted = CarService.deleteCar(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
