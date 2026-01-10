import java.util.Scanner;
import service.BankService;

public class Main {
    public static void main(String[] args) throws Exception {

        BankService bank = new BankService();
        try (Scanner sc = new Scanner(System.in)) {
            OUTER:
            while (true) {
                System.out.println("\n1.Register\n2.Login\n3.Forgot Password\n4.Exit");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1 -> {
                        System.out.print("Name: ");
                        String n = sc.next();
                        System.out.print("Email: ");
                        String e = sc.next();
                        System.out.print("Password: ");
                        String p = sc.next();
                        bank.register(n, e, p);
                        System.out.println("Account created");
                    }
                    case 2 -> {
                        System.out.print("Email: ");
                        String e = sc.next();
                        System.out.print("Password: ");
                        String p = sc.next();
                        int userId = bank.login(e, p);
                        if (userId != -1) {
                            System.out.println("Login successful");
                            
                            OUTER_1:
                            while (true) {
                                System.out.println("\n1.Balance\n2.Deposit\n3.Withdraw\n4.Logout");
                                int op = sc.nextInt();
                                switch (op) {
                                    case 1 -> System.out.println("Balance: " + bank.getBalance(userId));
                                    case 2 -> bank.deposit(userId, sc.nextDouble());
                                    case 3 -> bank.withdraw(userId, sc.nextDouble());
                                    case 4 -> {
                                        break OUTER_1;
                                    }
                                    default -> System.out.println("Invalid option");
                                }
                            }
                        } else {
                            System.out.println("Invalid login");
                        }
                    }
                    case 3 -> {
                        System.out.print("Email: ");
                        String e = sc.next();
                        System.out.print("New Password: ");
                        String p = sc.next();
                        bank.resetPassword(e, p);
                        System.out.println("Password reset done");
                    }
                    default -> {
                        break OUTER;
                    }
                }
            }
        }
    }
}
