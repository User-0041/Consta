package constat.mobile.dev.Repositorys;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import constat.mobile.dev.Entitys.Assurance;




public interface AssurancesRepository extends CrudRepository<Assurance, Integer> {

    boolean existsById(Long id);

    Optional<Assurance> findById(Long id);

    void deleteById(Long id);

    <id> Assurance saveAll(id assurance);

    Assurance save(Long assurance);

    

  


}