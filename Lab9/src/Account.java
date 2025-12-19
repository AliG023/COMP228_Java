public class Account {
    
    private String accountId;
    private String accountHolder;
    private double balance;


    public Account(String accountId, String accountHolder, double balance){
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }


    public String getAccountId() {
        return accountId;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public double getBalance() {
        return balance;
    }

    public String setAccountId(String accountId) {
        this.accountId = accountId;
        return accountId;
    }
    public String setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
        return accountHolder;
    }
    public double setBalance(double balance) {
        this.balance = balance;
        return balance;
    }
}