package constat.mobile.dev.Controlorles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import constat.mobile.dev.Entitys.Chouffeur;
import constat.mobile.dev.Entitys.Constat;
import constat.mobile.dev.Repositorys.vehicule;
import constat.mobile.dev.Repositorys.ConstatReporsitory;

@RestController
@RequestMapping("/vehicule")
public class Vehicule {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @GetMapping
    public List<Vehicule> getAllVehicule() {
        return vehiculeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id :" + id));
    }

    @PostMapping
    public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        Vehicule existingVehicule = vehiculeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id :" + id))
    }
}