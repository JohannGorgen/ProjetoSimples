package desafio.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import desafio.test.MagazineTest;

@RunWith(Suite.class)
@SuiteClasses({
	MagazineTest.class	
})

public class SuiteTest {

	//Classe que executa uma série de outras classes a partir dela
}
