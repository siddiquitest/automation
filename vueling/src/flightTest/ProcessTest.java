package flightTest;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import domain.*;

	public class ProcessTest {

	@Test
	public void Test() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "chromedriverw.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
	options.addArguments("start-maximized");
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	TestReader reader = new TestReader();
	List<Object[]> test = reader.readFile("src/test/TestDataVueling",FileType.XLSX);
	/*
	for(int i=0;i<test.size();i++){*/
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.vueling.com/es");
	driver.manage().window().maximize();

	DatosVuelo prueba1 = new DatosVuelo("Madrid", "Barcelona", 2, 2016, 5, 29);
	Pasajero pasajero1 = new Pasajero("Sarfaraz", true, "Siddiqui","España","Barcelona","España +34", "666666666","s@s.com");
	ContingencyPage contingency1 = new ContingencyPage("1 Maletas");
	DatosPago pago1 = new DatosPago("Sarfaraz Siddiqui", "1234567891234568", "1118", "999");
	BuscarVueloProcess process = new BuscarVueloProcess(driver, prueba1, pasajero1, contingency1, pago1);
	process.buscarVuelo();
	        driver.close();
	}
	}


	 
}
