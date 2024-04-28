package constat.mobile.dev.Repositorys;



import org.springframework.data.repository.CrudRepository;

import constat.mobile.dev.Entitys.Voiture;



@SuppressWarnings("hiding")
public interface VoitureRepository<Voiture> extends CrudRepository<Voiture, Integer> {


}