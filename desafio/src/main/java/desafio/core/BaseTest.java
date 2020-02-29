package desafio.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	//Classe base para execução dos testes. Ela tira screenshot da tela ao final do teste e fecha o navegador
	
	@Rule
	public TestName testName = new TestName();	
	
	@After
	public void end() throws IOException, InterruptedException{
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target\\screenshot\\" +  testName.getMethodName() + ".jpg"));
		
		Thread.sleep(3000);
		
		DriverFactory.killDriver();
	}

}
