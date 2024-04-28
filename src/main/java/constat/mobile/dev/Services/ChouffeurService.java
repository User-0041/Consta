package constat.mobile.dev.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constat.mobile.dev.Entitys.Chouffeur;
import constat.mobile.dev.Repositorys.ChouffeurRepository;

@Service
public class ChouffeurService {

    @Autowired
    private ChouffeurRepository chouffeurRepository;

    public List<Chouffeur> getAllChouffeur() {
        return (List<Chouffeur>) chouffeurRepository.findAll();
    }

    public Chouffeur getChouffeurById(Integer id) {
        return chouffeurRepository.findById(id).orElse(null);
    }

    public Chouffeur addChouffeur(Chouffeur chouffeur) {
        return chouffeurRepository.save(chouffeur);
    }

    public Chouffeur updateChouffeur(Integer id, Chouffeur newChouffeur) {
        Chouffeur existingChouffeur = chouffeurRepository.findById(id).orElse(null);
        if (existingChouffeur != null) {
            existingChouffeur.setName(newChouffeur.getName());
            existingChouffeur.setPermisDeConduire(newChouffeur.getPermisDeConduire());
            existingChouffeur.setDelivre(((Object) newChouffeur).getdelivre());
            return chouffeurRepository.save(existingChouffeur);
        }
        return null;
    }

    public boolean deleteChouffeur(Integer id) {
        if (chouffeurRepository.existsById(id)) {
            chouffeurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Chouffeur> getAllChauffeurs() {
        return(  List<Chouffeur>) chouffeurRepository.findAll();
    }
}
