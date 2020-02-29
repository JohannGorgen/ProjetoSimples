package desafio.test;

import org.junit.Before;
import org.junit.Test;

import desafio.core.BaseTest;
import desafio.core.DriverFactory;
import desafio.page.Steps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic(value = "Zup Challenge")
@Feature(value = "Busca em site de comercio")
public class MagazineTest extends BaseTest{
	
	//Classe que executa o teste
	private Steps steps;
	
	@Before
	public void initialize(){
		steps = new Steps();		
		DriverFactory.getDriver().navigate().to("https://www.magazineluiza.com.br/");
	}	
	
	@Test
	@Story("Busca no site da Magazine Luiza e valida a mesma.")
	@Description("Acessa o site da Magazine Luiza, pesquisa pelo item determinado, valida a busca, adiciona o item ao carrinho, valida o item e tira um print no final.")
	public void BuyItem() throws InterruptedException {
		steps.searchItem("155556000");
		steps.verifyItem();
		steps.selectItem();
		steps.addToBasket();
		steps.verifyBasket();		
	}	

}
