package constat.mobile.dev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assureurs")
public class AssureurController {

    @Autowired
    private AssureurService assureurService;

    @GetMapping
    public List<Assureur> getAllAssureurs() {
        return assureurService.getAllAssureurs();
    }

    @GetMapping("/{id}")
    public Optional<Assureur> getAssureurById(@PathVariable Long id) {
        return assureurService.getAssureurById(id);
    }

    @PostMapping
    public Assureur addAssureur(@RequestBody Assureur assureur) {
        return assureurService.addAssureur(assureur);
    }

    @PutMapping("/{id}")
    public Assureur updateAssureur(@PathVariable Long id, @RequestBody Assureur assureur) {
        return assureurService.updateAssureur(id, assureur);
    }

    @DeleteMapping("/{id}")
    public void deleteAssureur(@PathVariable Long id) {
        assureurService.deleteAssureur(id);
    }
}
