import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if (amount > 0){
            balance+=amount;
            System.out.println("Deposit successful. New balance: Rs  " + balance);
        }else{
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: Rs  " + balance);
        }else{
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}
class ATM{
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice!=4);
    }
    private void checkBalance(){
        System.out.println("Current balance: Rs " + account.getBalance());
    }
    private void deposit(){
        System.out.print("Enter the amount to deposit: Rs  ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw(){
        System.out.print("Enter the amount to withdraw: Rs ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); //Initial balance of Rs 1000
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
