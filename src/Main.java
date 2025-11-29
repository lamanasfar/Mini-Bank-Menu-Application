//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Account[] accounts = new Account[100];
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1-Create account");
            System.out.println("2-Deposit");
            System.out.println("3-Withdraw");
            System.out.println("4-Run special action (bonus / interest / fee)");
            System.out.println("5-Show account info");
            System.out.println("0-Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount(accounts);
                case 2 ->{
                    System.out.print("Enter account number: ");
                    String accNumber = sc.next();

                    Account acc = findAccount(accounts, accNumber);

                    if (acc == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        acc.deposit(amount);
                    }

                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String accNumber = sc.next();

                    Account acc = findAccount(accounts, accNumber);

                    if (acc == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        acc.withdraw(amount);

                    }
                }
                case 4 ->{
                    System.out.print("Enter account number: ");
                    String accNumber = sc.next();

                    Account acc = findAccount(accounts, accNumber);

                    if (acc instanceof LoanAccount) ((LoanAccount) acc).chargeInterest();
                    else if (acc instanceof DepositAccount) ((DepositAccount) acc).addMonthlyBonus();
                    else if(acc instanceof MortgageAccount) ((MortgageAccount) acc).addMonthlyFee();


                }
                case 5 ->{
                    System.out.print("Enter account number: ");
                    String accNumber = sc.next();

                    Account acc = findAccount(accounts, accNumber);
                    if (acc == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.println("Showing account info..." + acc);

                    }

                }
                case 0 -> {
                    System.out.println("Program exited.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static void  createAccount(Account[] accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number:");
        String accountNumber = sc.nextLine();

        System.out.println("Enter owner name:");
        String ownerName = sc.nextLine();

        System.out.println("Enter balance:");
        double balance = sc.nextDouble();

        System.out.println("Choose the account type");
        System.out.println("1-LoanAccount");
        System.out.println("2-DepositAccount ");
        System.out.println("3-MortgageAccount ");

        Account newAcc = null;

        int accType = sc.nextInt();

        switch (accType) {
            case 1 -> newAcc = new LoanAccount(accountNumber, ownerName, balance);
            case 2 -> newAcc = new DepositAccount(accountNumber, ownerName, balance);
            case 3 -> newAcc = new MortgageAccount(accountNumber, ownerName, balance);
            default -> {
                System.out.println("Invalid choice.");
                return;
            }


        }
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = newAcc;
                System.out.println("Account created successfully "  + newAcc);
                break;
            }
        }


    }

    public static Account findAccount(Account[] accounts, String accountNumber) {

        for(Account acc : accounts){
            if(acc!=null && acc.getAccountNumber().equals(accountNumber)){
                return acc;
            }


        }
        return null;

    }


}



