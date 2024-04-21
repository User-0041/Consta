package constat.mobile.dev.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constat.mobile.dev.Entitys.Car;
import constat.mobile.dev.Repositorys.CarRepository;

@Service
public class VehicleService {

    @Autowired
    private CarRepository CarRepository;

    // Méthode pour récupérer tous les véhicules
    public List<Car> getAllCars() {
        return (List<Car>) CarRepository.findAll();
    }

    // Méthode pour récupérer un véhicule par son ID
    public Car getCarById(String id) {
        Optional<Car> optionalCar = CarRepository.findById(id);
        return optionalCar.orElse(null);
    }

    // Méthode pour ajouter un nouveau véhicule
    public Car addCar(Car Car) {
        return CarRepository.save(Car);
    }

    // Méthode pour mettre à jour un véhicule existant
    public Car updateCar(String id, Car newCar) {
        Optional<Car> optionalCar = CarRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car existingCar = optionalCar.get();
           // existingCar.setAssureur(newCar.getAssureur());
            existingCar.setMarque(newCar.getMarque());
           // existingCar.setFrom(newCar.getFrom());
           // existingCar.setTo(newCar.getTo());
            // Mettez à jour d'autres propriétés selon vos besoins
            return CarRepository.save(existingCar);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer un véhicule
    public boolean deleteCar(String id) {
        Optional<Car> optionalCar = CarRepository.findById(id);
        if (optionalCar.isPresent()) {
            CarRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
