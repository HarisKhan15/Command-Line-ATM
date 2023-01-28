import java.util.*;

interface Bank {
    void withdraw();
    void deposit();
}
public class ATM implements Bank {


    private int balance;


    Scanner sc=new Scanner(System.in);
    Account obj=new Account();
    User userObj;
    ATM(User userObj){
        this.userObj=userObj;
    }
    public void run(){
        System.out.println("=====================\n||      Welcome    ||\n=====================");
        while (true) {
            System.out.print("\n__________________________________\n| Enter [ 1 ] for Check Balance  |\n| Enter [ 2 ] for Deposit Money  |\n| Enter [ 3 ] for Withdraw Money |\n| Enter [ 4 ] to log Out         |\n__________________________________\nEnter Your Choice Here ===> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n==================================\n Your Total Balance : "+obj.getBalance(userObj)+" \n==================================\n");
                    break;
                case 2:
                    this.balance= obj.getBalance(userObj);
                    deposit();
                    break;
                case 3:
                    this.balance= obj.getBalance(userObj);
                    withdraw();
                case 4:
                    break;
                default:
                    System.out.println("\n==================================\n| Invalid Input Please Try Again |\n==================================");
                    break;
            }
            if(choice == 4){
                System.out.println("\n======================\n| Log Out Successful |\n======================");
                userObj.login();
            }
        }


    }
    @Override
    public void withdraw() {
        System.out.print("\n__________________________________\nEnter amount you want to Withdraw : ");
        int wMoney=sc.nextInt();
        if(wMoney >= 500) {
            if (wMoney <= this.balance) {
                if (wMoney < 50000) {
                    this.balance -= wMoney;
                    obj.setBalance(this.balance, userObj);
                    System.out.println("\n\n==============================\n   WithDraw successful !!   \n------------------------------\n Remaining balance : " + this.balance + " \n==============================");
                } else {
                    System.out.println("\n===========================================\n| You can't Withdraw more than 50,000  !! |\n===========================================");
                }
            } else {
                System.out.println("\n===================================\n| You don't have enough money  !! |\n===================================");
            }
        }
        else{
            System.out.println("\n=======================================\n| You cannot WithDraw less than 500!! |\n=======================================");
        }

    }

    @Override
    public void deposit() {
        System.out.print("__________________________________\nEnter amount You want to Deposit : ");
        int dMoney = sc.nextInt();
        System.out.print("\n__________________________________\n");
        if(dMoney < 50000) {
            if (dMoney >= 500) {
                this.balance += dMoney;
                System.out.println("\n=========================\n Deposit successful !! \n-------------------------\n Total balance : " + this.balance + " \n=========================");
            } else {
                System.out.println("\n==================================\n|     Invalid Amount Entered     |\n| You cannot deposit below 500!! |\n==================================");
            }
        }else{
            System.out.println("\n===========================================\n| You can't Deposit more than 50,000   !! |\n===========================================");
        }

        obj.setBalance(this.balance,userObj);
    }
}