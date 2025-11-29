public class MortgageAccount extends Account {
    public MortgageAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    public void addMonthlyFee(){
        if(getBalance()<10) {
            System.out.println("Not enough money");
        }
        setBalance(getBalance() - 10);

    }
}