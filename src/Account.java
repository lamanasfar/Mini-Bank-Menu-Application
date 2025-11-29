import java.util.Objects;

public class Account {
    private String accountNumber;

    private String ownerName;

    private double balance;


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        if(accountNumber.isBlank() || accountNumber.length() < 4 ) {
            System.out.println("Invalid Account Number");
            return;
        }
        this.accountNumber = accountNumber;

    }

    public void setOwnerName(String ownerName) {
        if(ownerName.isBlank() || ownerName.length() < 3 ) {
            System.out.println("Invalid Owner Name");
            return;

        }
        this.ownerName = ownerName;
    }

    public void setBalance(double balance) {
        if(balance < 0) {
            System.out.println("Balance cannot be negative");
            return;
        }
        this.balance = balance;
    }

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public void deposit(double amount) {
        if(amount>0){
            balance += amount;
            System.out.println("Balance:" + balance);
        }
        else {
            System.out.println("Invalid amount!");
        }

    }
    public void withdraw(double amount) {
        if(amount<0){
            System.out.println("Invalid amount!");
            //bax
        }
        if(amount<=balance) {
            balance -= amount;
            System.out.println("Balance: " + balance);
        }
        else {
            System.out.println("Not enough balance!");
        }

    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }
}
