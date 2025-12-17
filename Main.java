import user.*;
import lenses.*;
import glasses.*;
import billing.*;
import threads.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║     WELCOME TO LENSORIA OPTICS        ║");
        System.out.println("║    Your Vision, Our Mission           ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        
        try {
            // Collect user information
            UserInfo user = new UserInfo();
            user.collectUserDetails(scanner);
            
            // Create billing manager
            BillingManager billingManager = new BillingManager(user);
            
            // Ask what user wants
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("What would you like to purchase?");
            System.out.println("1. Lenses Only");
            System.out.println("2. Glasses Only");
            System.out.println("3. Both Lenses and Glasses");
            System.out.print("Enter your choice (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch(choice) {
                case 1:
                    // Lenses only
                    LensManager lensManager = new LensManager(scanner);
                    lensManager.selectLenses();
                    billingManager.addItems(lensManager.getSelectedItems());
                    break;
                    
                case 2:
                    // Glasses only
                    GlassesManager glassesManager = new GlassesManager(scanner);
                    glassesManager.selectGlasses();
                    billingManager.addItems(glassesManager.getSelectedItems());
                    break;
                    
                case 3:
                    // Both
                    System.out.println("\n═══ LENSES SELECTION ═══");
                    LensManager lensManager2 = new LensManager(scanner);
                    lensManager2.selectLenses();
                    billingManager.addItems(lensManager2.getSelectedItems());
                    
                    System.out.println("\n═══ GLASSES SELECTION ═══");
                    GlassesManager glassesManager2 = new GlassesManager(scanner);
                    glassesManager2.selectGlasses();
                    billingManager.addItems(glassesManager2.getSelectedItems());
                    break;
                    
                default:
                    throw new InvalidChoiceException("Invalid choice! Please select 1, 2, or 3.");
            }
            
            // Generate and display bill
            billingManager.generateBill(scanner);
            
            // Start thank you thread
            ThankYouThread thankYouThread = new ThankYouThread(user.getName());
            thankYouThread.start();
            
            try {
                thankYouThread.join();
            } catch(InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
            
        } catch(InvalidChoiceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nSystem closed. Thank you!");
        }
    }
}