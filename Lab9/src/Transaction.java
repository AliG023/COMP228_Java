import java.lang.Math;

public class Transaction {
	
    private String id;
    private double amount;
    private String transType;
   
    
    public Transaction(double amount, String transType){
        this.id = generateId();
        this.amount = amount;
        this.transType = transType;
    }

    
    public String generateId() {
        return String.format("T%04d", (int)(Math.random() * 1000));
    }
    public double getAmount() {
        return amount;
    }
    public String getTransType() {
        return transType;
    }

    public double setAmount(double amount) {
        this.amount = amount;
        return amount;
    }
    public String setTransType(String transType) {
        this.transType = transType;
        return transType;
    }
}