import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    int accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(int accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Account balance: " + balance);
    }
}

class BankApplication {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Check Balance");
            System.out.println("5. List All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    accounts.add(new BankAccount(accountNumber, accountHolder, initialBalance));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = scanner.nextDouble();
                    for (BankAccount account : accounts) {
                        if (account.accountNumber == depositAccountNumber) {
                            account.deposit(depositAmount);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    for (BankAccount account : accounts) {
                        if (account.accountNumber == withdrawAccountNumber) {
                            account.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int balanceAccountNumber = scanner.nextInt();
                    for (BankAccount account : accounts) {
                        if (account.accountNumber == balanceAccountNumber) {
                            account.checkBalance();
                            break;
                        }
                    }
                    break;

                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        System.out.println("List of Accounts:");
                        for (BankAccount account : accounts) {
                            System.out.println("Account Number: " + account.accountNumber +
                                    ", Account Holder: " + account.accountHolder +
                                    ", Balance: " + account.balance);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
