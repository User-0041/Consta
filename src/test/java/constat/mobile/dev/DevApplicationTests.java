package constat.mobile.dev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import constat.mobile.dev.Entitys.Chouffeur;
import constat.mobile.dev.Entitys.Constat;
import constat.mobile.dev.Repositorys.ChouffeurRepository;
import constat.mobile.dev.Repositorys.ConstatReporsitory;

@SpringBootTest
class DevApplicationTests {
	@Autowired
	ChouffeurRepository  chouffeurRepository;
	@Autowired
	ConstatReporsitory  constatReporsitory;

	@Test
	void contextLoads() {
	}

	@Test
	void Mytest(){
		Chouffeur c1 = new Chouffeur();
		Chouffeur c2 = new Chouffeur();
		c1.setName("Barg");
		c2.setName("emna");
		Constat c = new Constat();
		c.setChouffeurA(c1);
		c.setChouffeurB(c2);
		chouffeurRepository.save(c1);
		chouffeurRepository.save(c2);

		constatReporsitory.save(c);


	}

}
