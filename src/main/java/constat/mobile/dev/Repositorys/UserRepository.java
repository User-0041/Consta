package constat.mobile.dev.Repositorys;



import org.springframework.data.repository.CrudRepository;

import constat.mobile.dev.Entitys.User;
public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsById(Long id);

    void deleteById(Long id);


}