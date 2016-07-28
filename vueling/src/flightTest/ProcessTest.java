package flightTest;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import domain.*;
import excelUtils.ExcelDataConfig;
import process.SearchFlight;
import websiteAPI.ServicePage;



	public class ProcessTest {

	@Test
	public void Test() throws InterruptedException{
		//READ EXCEL
		List<String> names=null;
		List<List<String>> tableData=null;
		
		ExcelDataConfig excel = new ExcelDataConfig("D:\\Users\\sarsiddi\\Documents\\eclipse\\TestDataVueling.xlsx");	
		
		
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\eclipse\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
	options.addArguments("start-maximized");
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	
	tableData = excel.columnToListNxN("book");
	
	
	for (int i = 1; i <10;  i++) 
		{
					
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.vueling.com/es");
		driver.manage().window().maximize();
	
		DataFlight test1 = new DataFlight(tableData.get(2).get(i).toString(), tableData.get(3).get(i).toString(), 2, 2016, 8, 29);
		Passenger passenger1 = new Passenger(tableData.get(20).get(i).toString(), true, tableData.get(19).get(i).toString(),tableData.get(25).get(i).toString(),tableData.get(26).get(i).toString(),tableData.get(25).get(i).toString()+" +"+tableData.get(27).get(i).toString(), tableData.get(28).get(i).toString(),tableData.get(29).get(i).toString());
		//ServicePage service1 = new ServicePage(driver);
		ServicePage service2 = new ServicePage(driver,tableData.get(30).get(i).toString(), tableData.get(38).get(i).toString(), "0");
		DataPayment payment = new DataPayment(tableData.get(46).get(i).toString(), tableData.get(47).get(i).toString(), tableData.get(48).get(i).toString(), tableData.get(49).get(i).toString());
		SearchFlight process = new SearchFlight(driver, test1, passenger1, service2);
		process.SearchFlight();
	   
		driver.close();
		}
			
		 
	
//	WebDriver driver = new ChromeDriver();
//	driver.get("http://www.vueling.com/es");
//	driver.manage().window().maximize();
//
//	DataFlight test1 = new DataFlight("Barcelona", "Madrid", 2, 2016, 8, 29);
//	Passenger passenger1 = new Passenger("Sarfaraz", true, "Siddiqui","España","Barcelona","España +34", "666666666","s@s.com");
//	//ContingencyPage contingency1 = new ContingencyPage("1 Maletas");
//	DataPayment payment = new DataPayment("Sarfaraz Siddiqui", "1234567891234568", "1118", "999");
//	SearchFlight process = new SearchFlight(driver, test1, passenger1, payment);
//	process.SearchFlight();
//
//	driver.quit();
	

  }
}


	 

