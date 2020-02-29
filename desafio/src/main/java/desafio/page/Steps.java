package desafio.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import desafio.core.DriverFactory;
import io.qameta.allure.Step;

public class Steps {
	
	//Classe onde os passos e elementos são definidos
	
	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
	
	String search = "#inpHeaderSearch";
	String searchButton = "#btnHeaderSearch";
	String result = "span.nm-total-results";
	String item = "div.nm-product-img-link";
	String addBasket = "button.button__buy.button__buy-product-detail.js-add-cart-button.js-main-add-cart-button.js-add-box-prime";
	String continueButton = "a.price-warranty__btn--continue.btn-buy-warranty";
	String productBasket = "p.BasketItemProduct-info-sku";
	
	@Step("Dado que eu pesquise um item no campo e busca.")
	public void searchItem(String text) throws InterruptedException{
		DriverFactory.getDriver().findElement(By.cssSelector(search)).clear();
		DriverFactory.getDriver().findElement(By.cssSelector(search)).sendKeys(text);
		DriverFactory.getDriver().findElement(By.cssSelector(searchButton)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(result)));
	}
	
	@Step("E verifique a quantidade de registros da pesqusa.")
	public void verifyItem(){
		String resultText = DriverFactory.getDriver().findElement(By.cssSelector(result)).getText();
		System.out.println("Resultado pesquisa >>>>> " + DriverFactory.getDriver().findElement(By.cssSelector(result)).getText());
		Assert.assertEquals("1", resultText);
	}
	
	@Step("E seleciono o item desejado.")
	public void selectItem(){
		DriverFactory.getDriver().findElement(By.cssSelector(item)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(addBasket)));
	}
	
	@Step("Quando adiciono o item no carrinho.")
	public void addToBasket(){
		DriverFactory.getDriver().findElement(By.cssSelector(addBasket)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(continueButton)));
		DriverFactory.getDriver().findElement(By.cssSelector(continueButton)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(productBasket)));
	}
	
	@Step("Então o mesmo deve estar no carrinho.")
	public void verifyBasket(){
		String result = DriverFactory.getDriver().findElement(By.cssSelector(productBasket)).getText();
		System.out.println("Resultado subtotal >>>>> " + DriverFactory.getDriver().findElement(By.cssSelector(productBasket)).getText());
		Assert.assertEquals("Código do produto: 155556000", result);
	}	

}
