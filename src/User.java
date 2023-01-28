import java.io.*;
import java.util.*;

public class User {
    private String userName,bankName,creditCardNo,accountNumber,pin;


    Scanner sc=new Scanner(System.in);
    ATM atmObj=new ATM(this);

    public void login(){
        while(true){
            System.out.println("==================\n||      ATM     ||\n==================");
            System.out.print("Enter [ 1 ] to login \nEnter [ 2 ] to Register \nEnter [ 3 ] to Exit \nEnter your choice ===>");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    checkUser();
                    break;
                case 2:
                    registerUser();
                    checkUser();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("====================\n| Invalid input!!  |\n| Please try again |\n====================");
            }

        }

    }
    public void checkUser() {
        int flag=0;
        try {

            System.out.print("\n========================================\nEnter your Credit Card number : ");
            this.creditCardNo = sc.nextLine();
            System.out.print("Enter your pin : ");
            this.pin = sc.nextLine();
            BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Haris khan\\IdeaProjects\\ATM\\" + this.creditCardNo + ".txt"));
            System.out.println("========================================\n");
            String pr;
            while((pr=br.readLine())!=null){
                if(pr.equals(this.pin)){
                    System.out.println("===========================\n| Operation successful !! |\n===========================\n");
                    flag=1;
                }
            }
            br.close();
            if(flag==1){
                atmObj.run();

            }
            else{
                System.out.println("============================\n| Incorrect Account or Pin |\n============================");

            }
        } catch (Exception e) {
            System.out.println("==========================\n| You are not registered |\n==========================");
        }

    }
    public void registerUser(){
        try {
            System.out.println("========================================");
            sc.nextLine();
            System.out.print("Enter your name : ");
            this.userName = sc.nextLine();
            System.out.print("Enter your Bank name : ");
            this.bankName = sc.nextLine();
            System.out.print("Enter Account Number : ");
            this.accountNumber = sc.nextLine();
            System.out.print("Enter Credit Card Number : ");

            this.creditCardNo = sc.nextLine();
            System.out.print("Enter Your Pin : ");
            this.pin = sc.nextLine();

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Haris khan\\IdeaProjects\\ATM\\" + this.creditCardNo + ".txt", true));
            Account.balanceI(500,this);
            bw.write(bankName + "\n" + userName + "\n" + creditCardNo + "\n" + accountNumber + "\n" + pin);
            bw.close();
            System.out.println("========================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public String getPin() {
        return pin;
    }
}