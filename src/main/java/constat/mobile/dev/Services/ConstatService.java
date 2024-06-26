package constat.mobile.dev.Services;

import org.springframework.stereotype.Service;

import constat.mobile.dev.Entitys.Constat;
import constat.mobile.dev.Repositorys.ConstatReporsitory;

import java.util.List;

@Service
public class ConstatService {

    private final ConstatReporsitory constatRepository;

    public ConstatService(ConstatReporsitory constatRepository) {
        this.constatRepository = constatRepository;
    }

    // Méthode pour récupérer tous les constats
    public List<Constat> getAllConstats() {
        return (List<Constat>) constatRepository.findAll();
    }

    // Méthode pour créer un nouveau constat
    public Constat createConstat(Constat constat) {
        return constatRepository.save(constat);
    }

    // Méthode pour récupérer un constat par son identifiant
    public Constat getConstatById(Integer id) {
        return constatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Constat non trouvé avec l'identifiant : " + id));
    }

    // Méthode pour mettre à jour un constat
    public Constat updateConstat(Integer id, Constat constatDetails) {
        Constat constat = constatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Constat non trouvé avec l'identifiant : " + id));

        constat.setDate(constatDetails.getDate());
        constat.setDescription(constatDetails.getDescription());
        // Ajoutez d'autres champs à mettre à jour au besoin

        return constatRepository.save(constat);
    }

    // Méthode pour supprimer un constat
    public void deleteConstat(Integer id) {
        Constat constat = constatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Constat non trouvé avec l'identifiant : " + id));

        constatRepository.delete(constat);
    }
}

