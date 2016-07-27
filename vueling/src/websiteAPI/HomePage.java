package websiteAPI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

            public class HomePage extends AbstractPage{

         By twoWay = By.id("AvailabilitySearchInputXmlSearchView_RoundTrip");
         By origen = By.name("AvailabilitySearchInputXmlSearchView$TextBoxMarketOrigin1");
         By destination = By.name("AvailabilitySearchInputXmlSearchView$TextBoxMarketDestination1");
         By searchFlight = By.id("AvailabilitySearchInputXmlSearchView_btnClickToSearchNormal");
         By oneWay = By.id("vuelo_ida");
         By dateIn = By.cssSelector("#datePickerContainer > div.ui-datepicker-group.ui-datepicker-group-last > table > tbody > tr:nth-child(3) > td:nth-child(4)");
         By dateOut = By.cssSelector("#datePickerContainer > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(5) > td:nth-child(3)");
							    

          public HomePage(WebDriver driver){
            this.driver = driver;
 }
           public void clicktwoWayButton(){
          click(twoWay);
   }
         public void origenSendKeys(String origenInput){
            sendKeys(origen, origenInput);
  }
           public void destinationSendKeys(String destinationInput){
               sendKeys(destination, destinationInput);
   }
           public void calendarClick(){
             Actions a =new Actions(driver);
             a .sendKeys(Keys.DOWN).build().perform();
      try {
      Thread.sleep(2000);
        } catch (InterruptedException e) {
           // TODO Auto-generated catch block
             e.printStackTrace();
         } 
            a.sendKeys(Keys.ENTER).build().perform();
                try{
                Thread.sleep(5000);
   
                click(dateIn);
                    Thread.sleep(5000);
                      click(dateOut);
    
              Thread.sleep(2000);
    
              } catch (InterruptedException e) {
                      // TODO Auto-generated catch block
                        e.printStackTrace();
             } 
               a.sendKeys(Keys.ENTER).build().perform();
 
   
           }
              public void noOfpassengerClick(int number){
                  click(By.id("DropDownListPassengerType_ADT_1"));
         }
                 public SchedulePage clickBuscarVuelo(){
                    if(driver.findElement(searchFlight).isEnabled()){
                       click(searchFlight);
                      return new SchedulePage(driver);
         }
                else{
                      return null;
   }
  }
   }