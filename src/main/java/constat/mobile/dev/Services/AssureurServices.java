package constat.mobile.dev.Services;

import org.springframework.data.repository.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssureurService {

    @Autowired
    private AssureurRepository assureurRepository;

    public List<Assureur> getAllAssureurs() {
        return assureurRepository.findAll();
    }

    public Optional<Assureur> getAssureurById(Long id) {
        return assureurRepository.findById(id);
    }

    public Assureur addAssureur(Assureur assureur) {
        return assureurRepository.save(assureur);
    }

    public void deleteAssureur(Long id) {
        assureurRepository.deleteById(id);
    }

    public Assureur updateAssureur(Long id, Assureur newAssureur) {
        Optional<Assureur> optionalAssureur = assureurRepository.findById(id);
        if (optionalAssureur.isPresent()) {
            Assureur assureur = optionalAssureur.get();
            assureur.setNom(newAssureur.getNom());
            assureur.setAdresse(newAssureur.getAdresse());
            return assureurRepository.save(assureur);
        } else {
            throw new RuntimeException("Assureur non trouvé avec l'ID : " + id);
        }
    }
}
