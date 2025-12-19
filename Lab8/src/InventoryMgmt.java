import java.util.HashMap;
import java.util.Map;

public class InventoryMgmt {
	
	// Inventory HashMap
    private final Map<String, Integer> inventory = new HashMap<>();

    
    // Add Stock Method
    public synchronized void addStock(String productId, int quantity) {
        inventory.put(productId, inventory.getOrDefault(productId, 0) + quantity);
        System.out.println("Added " + quantity + " of " + productId );
    }

    // Remove Stock Method
    public synchronized void removeStock(String productId, int quantity) {
        if (inventory.containsKey(productId)) {
            int currentStock = inventory.getOrDefault(productId, 0);
            if (currentStock >= quantity) {
                inventory.put(productId, currentStock - quantity);
                System.out.println("Removed " + quantity + " of " + productId);
            } else {    
                System.out.println("Not enough stock to remove " + quantity + " of " + productId + ". Current stock: " + currentStock);
            }
        } else {
            System.out.println("Product " + productId + " does not exist in inventory.");
        }
    }
    
    
    // Inventory Tracking Method
    public synchronized void displayInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}