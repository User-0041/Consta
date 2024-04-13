package constat.mobile.dev.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constat.mobile.dev.Entitys.Assureur;
import constat.mobile.dev.Repositorys.AssureurRepository;

@Service
public class AssureurService {

    @Autowired
    private AssureurRepository assureurRepository;

    public List<Assureur> getAllAssureurs() {
        return (List<Assureur>) assureurRepository.findAll();
    }

    public Optional<Assureur> getAssureurById(Integer id) {
        return assureurRepository.findById(id);
    }

    public Assureur addAssureur(Assureur assureur) {
        return assureurRepository.save(assureur);
    }

    public void deleteAssureur(Integer id) {
        assureurRepository.deleteById(id);
    }

    public Assureur updateAssureur(Integer id, Assureur newAssureur) {
        Optional<Assureur> optionalAssureur = assureurRepository.findById(id);
        if (optionalAssureur.isPresent()) {
            Assureur assureur = optionalAssureur.get();
            assureur.setTel(newAssureur.getTel());
            return assureurRepository.save(assureur);
        } else {
            throw new RuntimeException("Assureur non trouvé avec l'ID : " + id);
        }
    }
}
