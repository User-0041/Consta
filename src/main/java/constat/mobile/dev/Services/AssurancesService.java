package constat.mobile.dev.Services;

import org.springframework.data.repository.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssuranceService {

    @Autowired
    private AssuranceRepository assuranceRepository;

    // Méthode pour récupérer toutes les assurances
    public List<Assurance> getAllAssurances() {
        return assuranceRepository.findAll();
    }

    // Méthode pour récupérer une assurance par son ID
    public Assurance getAssuranceById(Long id) {
        return assuranceRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter une nouvelle assurance
    public Assurance addAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    // Méthode pour mettre à jour une assurance existante
    public Assurance updateAssurance(Long id, Assurance assurance) {
        if (assuranceRepository.existsById(id)) {
            assurance.setId(id);
            return assuranceRepository.save(assurance);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer une assurance
    public boolean deleteAssurance(Long id) {
        if (assuranceRepository.existsById(id)) {
            assuranceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
