import java.io.*;

public class Account {


    public static void balanceI(int money,User userObj){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Haris khan\\IdeaProjects\\ATM\\" + userObj.getCreditCardNo()+userObj.getPin() + ".txt"));
            String a=String.valueOf(money);
            bw.write(a);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setBalance(int balance,User userObj) {
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Haris khan\\IdeaProjects\\ATM\\" + userObj.getCreditCardNo()+userObj.getPin() + ".txt"));
            String b=String.valueOf(balance);
            bw.write(b);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int getBalance(User userObj) {
        int balanceReturn = 0;
        try{
            BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Haris khan\\IdeaProjects\\ATM\\" + userObj.getCreditCardNo() +userObj.getPin() + ".txt"));
            balanceReturn=Integer.parseInt(br.readLine());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return balanceReturn;

    }
}