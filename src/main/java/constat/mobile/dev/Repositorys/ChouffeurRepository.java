package constat.mobile.dev.Repositorys;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import constat.mobile.dev.Entitys.Chouffeur;



public interface ChouffeurRepository extends CrudRepository<Chouffeur , Integer> {

    Optional<Chouffeur> findById(Long id);

   
}
    


