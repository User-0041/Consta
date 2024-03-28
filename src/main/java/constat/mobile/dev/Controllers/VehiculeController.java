package constat.mobile.dev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    // Endpoint pour récupérer tous les véhicules
    @GetMapping
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> vehicules = vehiculeService.getAllVehicules();
        return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }

    // Endpoint pour récupérer un véhicule par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable("id") Long id) {
        Vehicule vehicule = vehiculeService.getVehiculeById(id);
        if (vehicule != null) {
            return new ResponseEntity<>(vehicule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour ajouter un nouveau véhicule
    @PostMapping
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule) {
        Vehicule newVehicule = vehiculeService.addVehicule(vehicule);
        return new ResponseEntity<>(newVehicule, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un véhicule existant
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable("id") Long id, @RequestBody Vehicule vehicule) {
        Vehicle updatedVehicule = vehiculeService.updateVehicule(id, vehicule);
        if (updatedVehicule != null) {
            return new ResponseEntity<>(updatedVehicule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un véhicule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable("id") Long id) {
        boolean deleted = vehiculeService.deleteVehicule(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
