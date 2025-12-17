package billing;

import user.UserInfo;
import interfaces.Selectable;
import java.util.*;

public class BillingManager {
    private UserInfo user;
    private List<Selectable> items;
    private double subtotal;
    private double gst;
    private double discount;
    private double finalTotal;
    private boolean freeSunglasses;
    private String paymentMethod;
    
    public BillingManager(UserInfo user) {
        this.user = user;
        this.items = new ArrayList<>();
        this.subtotal = 0.0;
        this.gst = 0.0;
        this.discount = 0.0;
        this.finalTotal = 0.0;
        this.freeSunglasses = false;
    }
    
    public void addItems(List<Selectable> newItems) {
        items.addAll(newItems);
    }
    
    public void generateBill(Scanner scanner) {
        try {
            if(items.isEmpty()) {
                throw new NegativePriceException("No items selected!");
            }
            
            // Calculate subtotal
            for(Selectable item : items) {
                double price = item.calculatePrice();
                if(price < 0) {
                    throw new NegativePriceException("Item price cannot be negative!");
                }
                subtotal += price;
            }
            
            // Calculate GST
            gst = subtotal * 0.08;
            double totalBeforeDiscount = subtotal + gst;
            
            // Check for free sunglasses
            if(totalBeforeDiscount > 4000) {
                freeSunglasses = true;
            }
            
            // Payment method
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("SELECT PAYMENT METHOD");
            System.out.println("═══════════════════════════════════════");
            System.out.println("1. UPI (5% discount)");
            System.out.println("2. Card (10% discount)");
            System.out.println("3. Cash (No discount)");
            System.out.print("Enter your choice (1-3): ");
            
            int paymentChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch(paymentChoice) {
                case 1:
                    paymentMethod = "UPI";
                    discount = totalBeforeDiscount * 0.05;
                    break;
                case 2:
                    paymentMethod = "Card";
                    discount = totalBeforeDiscount * 0.10;
                    break;
                case 3:
                    paymentMethod = "Cash";
                    discount = 0.0;
                    break;
                default:
                    throw new InvalidPaymentException("Invalid payment method!");
            }
            
            finalTotal = totalBeforeDiscount - discount;
            
            // Display bill
            displayBill();
            
        } catch(NegativePriceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(InvalidPaymentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error generating bill: " + e.getMessage());
        } finally {
            System.out.println("\nBilling process completed.");
        }
    }
    
    private void displayBill() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║               LENSORIA OPTICS                     ║");
        System.out.println("║              INVOICE / BILL                       ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        
        System.out.println("\n─────────── CUSTOMER DETAILS ───────────");
        user.displayUserInfo();
        
        System.out.println("\n─────────── ITEMS PURCHASED ───────────");
        int itemNo = 1;
        for(Selectable item : items) {
            System.out.println(itemNo + ". " + item.getItemDescription());
            itemNo++;
        }
        
        System.out.println("\n─────────── BILLING SUMMARY ───────────");
        System.out.printf("Subtotal:          Rs.%.2f\n", subtotal);
        System.out.printf("GST (8%%):         Rs.%.2f\n", gst);
        System.out.printf("Total:             Rs.%.2f\n", subtotal + gst);
        System.out.printf("Discount:          -Rs.%.2f\n", discount);
        System.out.println("───────────────────────────────────────");
        System.out.printf("FINAL AMOUNT:      Rs.%.2f\n", finalTotal);
        System.out.println("───────────────────────────────────────");
        System.out.printf("Payment Method:    %s\n", paymentMethod);
        
        if(freeSunglasses) {
            System.out.println("\n CONGRATULATIONS! ");
            System.out.println("You get FREE SUNGLASSES worth Rs.1800!");
        }
        
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("Thank you for shopping at Lensoria!");
        System.out.println("═══════════════════════════════════════\n");
    }
}