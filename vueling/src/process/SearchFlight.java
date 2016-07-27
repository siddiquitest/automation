package process;

import java.util.ArrayList;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.thoughtworks.selenium.webdriven.commands.Submit;

import domain.DataFlight;
import domain.Passenger;
import websiteAPI.*;
import domain.DataPayment;

        public class SearchFlight{
        WebDriver driver;
        DataFlight data;
        Passenger passenger;
        ServicePage service;
       // DataPayment payment;
    
          public SearchFlight(WebDriver driver, DataFlight data, Passenger passenger, ServicePage service){
          this.driver = driver;
          this.data = data;
          this.passenger = passenger;
          this.service = service;
          //this.payment = payment;
   }
        public void SearchFlight() throws InterruptedException{
        SchedulePage selectPage = introduceData();
        ContactPage contactPage = elegirVuelo(selectPage);
        pasajeroInfo(contactPage);
        ServicePage service = new  ServicePage(driver);
       // ServicePage servicePage = PaginaPago(service);
       /* PaymentPage dataPayment = new  PaymentPage(driver);
        PaymentPage paymentPage = FinalPage(dataPayment);
   */
   }   


         private ServicePage service() {
        // TODO Auto-generated method stub
        return null;
   }

          private SchedulePage introduceData() {
          HomePage home = new HomePage(driver);
          //home.clickIdaYvueltaButton();
           home.origenSendKeys(data.getOrigen());
           home.destinationSendKeys(data.getDestination());
           home.calendarClick();
           home.noOfpassengerClick(data.getNumberOfPassenger());
            return home.clickBuscarVuelo();
     }
            private ContactPage elegirVuelo(SchedulePage selectPage){
            selectPage.selectFirstFlight();
            selectPage.selectSecondFlight();
            return selectPage.submitButton();

   }
    
       public void pasajeroInfo(ContactPage contact){
        if(passenger.Isman())
        contact.clickSr();
        else
        contact.clickSra();
        
        contact.nameSendKeys(passenger.getName());
        contact.SurnameSendKeys(passenger.getSurname());
        contact.countrySendKeys(passenger.getCountry());   
        contact.cityOfCountry(passenger.getCity()); 
        contact.prefixCountry(passenger.getPrefix());
        contact.telefonoPais(passenger.getTelephone());
        contact.emailpasajero(passenger.getEmail());
        contact.clickCondition();
        contact.contactSubmit();
             
    }
//    private ServicePage PaginaPago(ServicePage service) throws InterruptedException{
//      service.clickNoAsiento("0");
//        /*   service.SelectSeat(); */
//      
//      service.clickMaleta("0");
//      service.clickInsuraneCancel("0");
//  //     service.añadirMaleta(contingencyPage.getAñadirMaleta());
//      service.clickSinseguro();
//           service.clickserviceButton();
//           return service;
//    }
           
   

       /* public PaymentPage FinalPage(PaymentPage dataPayment) throws InterruptedException{

       dataPayment.tipoDeTarjeta();
       //datospago.tipoDeTarjeta(pago.getTarjeta());
      Thread.sleep(1000);
          dataPayment.cardHolder(payment.getTitle());
          dataPayment.cardNumber(payment.getCardNumber());
          dataPayment.cardExpiry(payment.getexpiryDate());
          dataPayment.cvvNumber(payment.getCvv());
          dataPayment.paymentButton();
          return dataPayment;*/
    }
         
    
