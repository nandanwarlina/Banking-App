import service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account ID: ");
        int accId = sc.nextInt();

        System.out.print("Enter transaction type (deposit/withdraw): ");
        String type = sc.next();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        try {
            if (type.equalsIgnoreCase("deposit")) {
                bank.deposit(accId, amount);
            } else if (type.equalsIgnoreCase("withdraw")) {
                bank.withdraw(accId, amount);
            } else {
                System.out.println("Invalid transaction type.");
            }
            System.out.println("Updated Account: " + bank.getAccount(accId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
