import java.util.Scanner;


public class InventoryDriver {
    public static void main(String[] args) {
        InventoryMgmt inventory = new InventoryMgmt();
        Scanner scan = new Scanner(System.in);
        
        
        // Thread 1 - Add stock
        Thread addThread1 = new Thread(() -> {
            synchronized(scan) {
                System.out.println("\n[Add Stock]");
                System.out.print("Enter product ID to add: ");
                String productId = scan.nextLine();
                System.out.print("Enter quantity to add: ");
                int quantity = scan.nextInt();
                scan.nextLine();
                inventory.addStock(productId, quantity);
            }
        });
        
        // Thread 2 - Add stock
        Thread addThread2 = new Thread(() -> {
            synchronized(scan) {
                System.out.println("\n[Add Stock]");
                System.out.print("Enter product ID to add: ");
                String productId = scan.nextLine();
                System.out.print("Enter quantity to add: ");
                int quantity = scan.nextInt();
                scan.nextLine();
                inventory.addStock(productId, quantity);
            }
        });
        
        // Thread 3 - Remove stock
        Thread removeThread1 = new Thread(() -> {
            synchronized(scan) {
                System.out.println("\n[Remove Stock]");
                System.out.print("Enter product ID to remove: ");
                String productId = scan.nextLine();
                System.out.print("Enter quantity to remove: ");
                int quantity = scan.nextInt();
                scan.nextLine();
                inventory.removeStock(productId, quantity);
            }
        });
        

        System.out.println("=== Inventory Management System ===");
        
        // Starts Threads
        addThread1.start();
        addThread2.start();
        removeThread1.start();
        
        // Waits For Threads To Finish
        try {
            addThread1.join();
            addThread2.join();
            removeThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Stops the Thread when Safe - Although this is redundant after the .join() method
        addThread1.interrupt();
        addThread2.interrupt();
        removeThread1.interrupt();
        
        
        System.out.println("\n=== Inventory Update ===");
        System.out.println("");
        inventory.displayInventory();
        System.out.println("");
        scan.close();
        System.out.println("\nInventory management completed!");
    }
}