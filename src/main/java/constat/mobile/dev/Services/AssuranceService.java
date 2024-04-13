package constat.mobile.dev.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constat.mobile.dev.Entitys.Assurances;
import constat.mobile.dev.Repositorys.AssurancesRepository;

@Service
public class AssuranceService {

    @Autowired
    private AssurancesRepository assuranceRepository;

    // Méthode pour récupérer toutes les assurances
    public List<Assurances> getAllAssurances() {
        return (List<Assurances>) assuranceRepository.findAll();
    }

    // Méthode pour récupérer une assurance par son ID
    public Assurances getAssuranceById(Integer id) {
        return assuranceRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter une nouvelle assurance
    public Assurances addAssurance(Assurances assurance) {
        return assuranceRepository.save(assurance);
    }

    // Méthode pour mettre à jour une assurance existante
    public Assurances updateAssurance(Integer id, Assurances assurance) {
        if (assuranceRepository.existsById(id)) {
            assurance.setId(id);
            return assuranceRepository.save(assurance);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer une assurance
    public boolean deleteAssurance(Integer id) {
        if (assuranceRepository.existsById(id)) {
            assuranceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
