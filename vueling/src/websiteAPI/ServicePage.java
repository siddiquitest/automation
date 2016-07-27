package websiteAPI;



import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



                 public class ServicePage extends AbstractPage{
 
                     By CloseWindow = By.id("ContingencyServicesClose");
                     By Noasiento = By.cssSelector("#noChooseSeats");
                     By Maleta    = By.xpath("//*[@id=\"CONTROLGROUPSERVICES_BaggageViewServicesView\"]/div/div/div[2]/div/div/div");
                     By Bags = By.id("CONTROLGROUPSERVICES_BaggageViewServicesView_SSRBaggageInputViewServicesView_SSRCode_PASSENGERCOUNT_0_SSRCOUNT_0");
                     By Sinseguro = By.xpath("//*[@id=\"insure_SENO_ToBottom\"]");
                     By ServiceButton = By.xpath("//*[@id=\"CONTROLGROUPSERVICES_LinkButtonSubmit\"]");
                     By ChooseSeat = By.cssSelector("#paySeats > div.wrap_btSmall_plus.seats-section-footer > div > a");
                     By InsuranceCancel = By.id("insure_SEA");

                       public ServicePage(WebDriver driver){
                          this.driver = driver;
                       }
                          public ServicePage(WebDriver driver, String bag, String InsuranceCancel, String noAsiento){
                        	  clickNoAsiento(noAsiento);
                        	  try {
								clickMaleta(bag);
								clickInsuraneCancel(InsuranceCancel);
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
								e.printStackTrace();
							}
                        	  
                              this.driver = driver;
     }
        
               public void closeWindow(){
                   ArrayList<String> a2=new ArrayList<String>(driver.getWindowHandles());
                    driver.findElement(By.id("ContingencyServicesClose")).click();
         }
               public void clickNoAsiento(String valor){
                   if(valor=="0") 
	                   {
	            	   click(Noasiento);
	            	   }
                 }
       
             public void clickMaleta(String valor) throws InterruptedException{
                 Thread.sleep(2000);
	                 if(valor=="0") 
	                 {   
	                 click(Maleta);
	                 }
              }
             
             public void clickInsuraneCancel(String valor) throws InterruptedException{
            	 Thread.sleep(2000);
	            	  if(valor=="0") 
	                  {
	            	 click(InsuranceCancel);
	                  }
             }
          public void añadirMaleta(String bags) throws InterruptedException{
           Select s2=new Select(driver.findElement(By.name("CONTROLGROUPSERVICES$BaggageViewServicesView$SSRBaggageInputViewServicesView$SSRCode_PASSENGERCOUNT_0_SSRCOUNT_0")));
           s2.selectByValue("BAG2");
        }
       
       
               
        public void clickSinseguro() throws InterruptedException{
            Thread.sleep(1000);
        click(Sinseguro);
        }
       
         public PaymentPage clickserviceButton() throws InterruptedException {
        Thread.sleep(2000);
         click(ServiceButton);
        return new PaymentPage(driver);
         }
        public void SelectSeat(){
        click(ChooseSeat);
        }
       
        public void ClickInsuranceCancel(){
        click(InsuranceCancel);
        }
        }
