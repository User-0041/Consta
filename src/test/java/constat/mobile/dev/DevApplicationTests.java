package constat.mobile.dev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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



	}

}
