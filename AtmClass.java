/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melody;
// Methods of an ATM.
/**
 * withdrawal
 * set new pin
 * deposit
 * transfer
 * check balance.
 * recharge.
 */
// objects of an ATM.
/**
 * message
 * pin
 * amount
 * number
 * acc number
 * 
 */
import java.util.Scanner;

/**
 *
 * @author USE
 */
public class AtmClass {

    
    int pin;
    String message;
    float balance;
    
    
    public int getpin() {return pin;}
    
    public void setpin(int pin){this.pin = pin;} 
    
    public float getbalance() {return balance;}
    
    public void setbalance(int balance){this.balance = balance;}
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      System.out.println("WELCOME TO MELODIC BANK" + "\n" + "please insert your card");
      transaction();
      
      
    }
    public static void transaction(){
    int code;
        // all operations happens here
             
       AtmClass Melody = new AtmClass();
       Melody.setpin(1235); //set a default pin
       
       
       AtmClass Balance = new AtmClass();
       Balance.setbalance(2000);// initialize balance for everyone.
       
       
       System.out.println(" ");
       System.out.println("*************************************************************************");// this demacates the code
       Scanner pinset = new Scanner(System.in);
       System.out.println("please enter your secret number ");
       code = pinset.nextInt();// aunthenticate pin.
       
       if (code == Melody.pin){
           System.out.println("*************************************************************************");
           System.out.println( "1. Withdraw Cash" + "\n" + "2. deposit cash" + "\n" +"3. check balance" + "\n" + "Please choose a transaction ");
           System.out.println("*************************************************************************");
       }//choose transaction   
       else{ 
          System.out.println("*************************************************************************");
          System.out.println("Incorrect pin");
          transaction();
       }
       int choice;
       choice = pinset.nextInt();// collect transaction input.
       switch(choice){
           case 1:// operation for withdrawal.
               float amount;
               System.out.println("*************************************************************************");
               System.out.println("PLEASE INPUT THE AMOUNT, YOU WISH TO WITHDRAW");
               System.out.println("*************************************************************************");
               amount = pinset.nextFloat();
               
               if (amount > Balance.balance){
               System.out.println("*************************************************************************");
               System.out.println("Sorry you the not have sufficient funds");
               newTransaction();// ask if they want another tranaction
               }else if(amount < Balance.balance || amount == Balance.balance){
                System.out.println("*************************************************************************");   
                   Balance.balance -= amount;// updates the balance after withdrawal.
               System.out.println("Please wait while your transaction is procesing......");
               System.out.println("******************************************************");
               System.out.println("collect your cash");
               System.out.println("******************************************************");
               System.out.println("You have withdrawn " + amount + " Your new balance is "+ Balance.balance);
               newTransaction();
               }else{
               System.out.println("Temporarily unable to dispense cash");
               newTransaction();
               }
               
           break;
          
           case 2:
           //for cash deposit
               float deposit;
               System.out.println("How much do you wish to deposit");
               deposit = pinset.nextFloat();
               Balance.balance += deposit; // this updates your balance.
               System.out.println("You have deposited " + deposit + "your new balance is" + Balance.balance);
               newTransaction();
           break;
               
           case 3:
               // This performs the operation balance checking.
               System.out.println("Your current balnace is " + Balance.balance);
               newTransaction();
           break;    
           
           default:
            System.out.println("Imvalid option:\n");
            newTransaction();
            break;
       }
       
       
    }
    public static void newTransaction(){
        int anyTransaction;
        Scanner in = new Scanner(System.in);
        System.out.println("*************************************************************************");
        System.out.println("Do you wish to continue" + "\n" + "1. YES" + " \n" + "2. NO");
        anyTransaction = in.nextInt();
        switch(anyTransaction ){
        case 1: 
            transaction();
        break;
        case 2:
            System.out.println("*************************************************************************");
            System.out.println("Thank you for Banking with us");
        break;
        default:
            System.out.println("*************************************************************************");
            System.out.println("INvalid option:\n");
            newTransaction();
        break;
        }
       }

}
