package constat.mobile.dev.Services;

import org.springframework.data.repository.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class import org.springframework.data.repository.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChouffeurService {

    @Autowired
    private ChouffeurRepository chouffeurRepository;

    public List<Chouffeur> getAllChouffeur() {
        return chouffeurRepository.findAll();
    }

    public Chouffeur getChouffeurById(Long id) {
        return chouffeurRepository.findById(id).orElse(null);
    }

    public Chouffeur addChouffeur(Chouffeur chouffeur) {
        return chouffeurRepository.save(chouffeur);
    }

    public Chouffeur updateChouffeur(Long id, Chouffeur newChouffeur) {
        Chouffeur existingChouffeur = chouffeurRepository.findById(id).orElse(null);
        if (existingChouffeur != null) {
            existingChouffeur.setName(newChouffeur.getName());
            existingChouffeur.setLicenseNumber(newChouffeur.getLicenseNumber());
            // Mettez à jour d'autres attributs si nécessaire
            return chouffeurRepository.save(existingChouffeur);
        }
        return null;
    }

    public boolean deleteChouffeur(Long id) {
        if (chouffeurRepository.existsById(id)) {
            chouffeurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
 {

    @Autowired
    private ChouffeurRepository chouffeurRepository;

    public List<Chouffeur> getAllChouffeur() {
        return chouffeurRepository.findAll();
    }

    public Chouffeur getChouffeurrById(Long id) {
        return chouffeurRepository.findById(id).orElse(null);
    }

    public Chouffeur addChouffeur(Chouffeur chouffeur) {
        return chouffeurRepository.save(chouffeur);
    }

    public Chouffeur updateChouffeur(Long id, Chouffeur newChouffeur) {
        Chouffeur existingChouffeur = ChouffeurRepository.findById(id).orElse(null);
        if (existingChouffeur != null) {
            existingChouffeur.setName(newChouffeur.getName());
            existingChouffeur.setLicenseNumber(newChouffeur.getLicenseNumber());
            // Mettez à jour d'autres attributs si nécessaire
            return chouffeurRepository.save(existingChouffeur);
        }
        return null;
    }

    public boolean deleteChouffeur(Long id) {
        if (chouffeurRepository.existsById(id)) {
            chouffeurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
