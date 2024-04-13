package constat.mobile.dev.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constat.mobile.dev.Entitys.Vehicule;
import constat.mobile.dev.Repositorys.VehiculeRepository;

@Service
public class VehicleService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    // Méthode pour récupérer tous les véhicules
    public List<Vehicule> getAllVehicules() {
        return (List<Vehicule>) vehiculeRepository.findAll();
    }

    // Méthode pour récupérer un véhicule par son ID
    public Vehicule getVehiculeById(String id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        return optionalVehicule.orElse(null);
    }

    // Méthode pour ajouter un nouveau véhicule
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // Méthode pour mettre à jour un véhicule existant
    public Vehicule updateVehicule(String id, Vehicule newVehicule) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isPresent()) {
            Vehicule existingVehicule = optionalVehicule.get();
            existingVehicule.setAssureur(newVehicule.getAssureur());
            existingVehicule.setMarque(newVehicule.getMarque());
           // existingVehicule.setFrom(newVehicule.getFrom());
           // existingVehicule.setTo(newVehicule.getTo());
            // Mettez à jour d'autres propriétés selon vos besoins
            return vehiculeRepository.save(existingVehicule);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer un véhicule
    public boolean deleteVehicule(String id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isPresent()) {
            vehiculeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
