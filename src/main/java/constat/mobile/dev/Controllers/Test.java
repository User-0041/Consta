/*Package constat.mobile.dev.Controlorles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import constat.mobile.dev.Entitys.Chouffeur;
import constat.mobile.dev.Entitys.Constat;
import constat.mobile.dev.Repositorys.ChouffeurRepository;
import constat.mobile.dev.Repositorys.ConstatReporsitory;

@RestController
public class Test {
    	@Autowired
	ChouffeurRepository  chouffeurRepository;
	@Autowired
	ConstatReporsitory  constatReporsitory;
     @GetMapping("/Test")
    List<Constat> all() {

        Chouffeur c1 = new Chouffeur();

        Chouffeur c2 = new Chouffeur();
		c1.setName("Barg El Lil");
		c2.setName("9ar3ish");

		Constat c = new Constat();
		c.setChouffeurA(c1);
		c.setChouffeurB(c2);
		chouffeurRepository.save(c1);
		chouffeurRepository.save(c2);
		constatReporsitory.save(c);
		System.out.println(constatReporsitory.findAll());
        return (List<Constat>) constatReporsitory.findAll() ;
      }
}*/
