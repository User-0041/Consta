package constat.mobile.dev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chauffeur")
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;

    // Endpoint pour récupérer tous les chauffeurs
    @GetMapping
    public ResponseEntity<List<Chauffeur>> getAllChauffeurs() {
        List<Chauffeur> chauffeurs = chauffeurService.getAllChauffeurs();
        return new ResponseEntity<>(chauffeurs, HttpStatus.OK);
    }

    // Endpoint pour récupérer un chauffeur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Chauffeur> getChauffeurById(@PathVariable("id") Long id) {
        Chauffeur chauffeur = chauffeurService.getChauffeurById(id);
        if (chauffeur != null) {
            return new ResponseEntity<>(chauffeur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour ajouter un nouveau chauffeur
    @PostMapping
    public ResponseEntity<Chauffeur> addChauffeur(@RequestBody Chauffeur chauffeur) {
        Chauffeur newChauffeur = chauffeurService.addChauffeur(chauffeur);
        return new ResponseEntity<>(newChauffeur, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un chauffeur existant
    @PutMapping("/{id}")
    public ResponseEntity<Chauffeur> updateChauffeur(@PathVariable("id") Long id, @RequestBody Chauffeur chauffeur) {
        Chauffeur updatedChauffeur = chauffeurService.updateChauffeur(id, chauffeur);
        if (updatedChauffeur != null) {
            return new ResponseEntity<>(updatedChauffeur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un chauffeur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChauffeur(@PathVariable("id") Long id) {
        boolean deleted = chauffeurService.deleteChauffeur(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
