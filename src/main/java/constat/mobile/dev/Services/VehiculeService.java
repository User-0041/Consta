package constat.mobile.dev.Services;

import org.springframework.data.repository.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    // Méthode pour récupérer tous les véhicules
    public List<Vehicule> getAllVehicules() {
        return .findAll();
    }

    // Méthode pour récupérer un véhicule par son ID
    public Vehicule getVehiculeById(Long id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        return optionalVehicule.orElse(null);
    }

    // Méthode pour ajouter un nouveau véhicule
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // Méthode pour mettre à jour un véhicule existant
    public Vehicule updateVehicule(Long id, Vehicule newVehicule) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isPresent()) {
            Vehicule existingVehicule = optionalVehicule.get();
            existingVehicule.setBrand(newVehicule.getBrand());
            existingVehicule.setModel(newVehicule.getModel());
            existingVehicule.setYear(newVehicule.getYear());
            // Mettez à jour d'autres propriétés selon vos besoins
            return vehiculeRepository.save(existingVehicule);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer un véhicule
    public boolean deleteVehicule(Long id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isPresent()) {
            vehiculeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
