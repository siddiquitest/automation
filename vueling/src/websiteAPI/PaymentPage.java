package websiteAPI;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

	
	
	   public class PaymentPage extends AbstractPage{
	    By Card = By.name("CONTROLGROUPPAYMENTBOTTOM$ControlGroupPaymentInputViewPaymentView$paymentMethodSelectCombobox");
	    By CardHolder = By.name("CONTROLGROUPPAYMENTBOTTOM$ControlGroupPaymentInputViewPaymentView$TextBoxCC::AccountHolderName");
	    By CardNumber = By.name("CONTROLGROUPPAYMENTBOTTOM$ControlGroupPaymentInputViewPaymentView$TextBoxACCTNO");
	    By CardExpiry = By.name("CONTROLGROUPPAYMENTBOTTOM$ControlGroupPaymentInputViewPaymentView$TextBoxEXPDAT_MONTH_YEAR");
	    By Cvv = By.name("CONTROLGROUPPAYMENTBOTTOM$ControlGroupPaymentInputViewPaymentView$TextBoxCC::VerificationCode");
	    By Payment = By.xpath("//*[@id=\"CONTROLGROUPPAYMENTBOTTOM_ControlGroupPaymentInputViewPaymentView_LinkButtonSubmit\"]");
	  
	   public PaymentPage(WebDriver driver){
	        this.driver = driver;
	  }
	  public void tipoDeTarjeta() throws InterruptedException{
	  Actions a =new Actions(driver);
	   a .sendKeys(Keys.DOWN).build().perform();
	   Thread.sleep(1000);

	   a.sendKeys(Keys.ENTER).build().perform();
	  click(Card);

	 }
	 /*public void tipoDeTarjeta(String card){
	 sendKeys(Card, card);
	 }*/
	 public void cardHolder(String cardHolder){
	 sendKeys(CardHolder, cardHolder);
	 }
	 public void cardNumber(String cardNumber) {
	 sendKeys(CardNumber, cardNumber);
	 }
	 public void cardExpiry(String cardExpiry){
	 sendKeys(CardExpiry, cardExpiry);
	 }
	     public void cvvNumber(String cvv){
	    sendKeys(Cvv, cvv);
	   
	     }  
	    public void paymentButton(){
	    click(Payment);

	    }
	     }



