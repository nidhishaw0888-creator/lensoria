package utils;

import java.util.StringTokenizer;

public class TextProcessor {
    
    // Using StringBuffer to build formatted text
    public static StringBuffer buildBillHeader(String billNumber, String date, String time) {
        StringBuffer header = new StringBuffer();
        
        header.append("╔═══════════════════════════════════════════════╗\n");
        header.append("║           LENSORIA OPTICS                     ║\n");
        header.append("║           INVOICE / BILL                      ║\n");
        header.append("╚═══════════════════════════════════════════════╝\n");
        header.append("Bill Number: ").append(billNumber).append("\n");
        header.append("Date: ").append(date).append("\n");
        header.append("Time: ").append(time).append("\n");
        
        return header;
    }
    
    // Using StringTokenizer to parse item descriptions
    public static void parseItemDescription(String description) {
        StringTokenizer tokenizer = new StringTokenizer(description, "-");
        
        System.out.println("\n--- Parsed Item Details ---");
        int count = 1;
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            System.out.println("Part " + count + ": " + token);
            count++;
        }
    }
    
    // Using StringBuffer to create customer info section
    public static StringBuffer buildCustomerInfo(String name, int age, String gender, String phone) {
        StringBuffer info = new StringBuffer();
        
        info.append("\n─────────── CUSTOMER DETAILS ───────────\n");
        info.append("Customer Name: ").append(name).append("\n");
        info.append("Age: ").append(age).append("\n");
        info.append("Gender: ").append(gender).append("\n");
        info.append("Phone: ").append(phone).append("\n");
        
        return info;
    }
    
    // Using StringTokenizer to validate phone number format
    public static boolean validatePhoneWithTokenizer(String phone) {
        // Check if phone contains only digits using StringTokenizer
        StringTokenizer tokenizer = new StringTokenizer(phone, "0123456789", true);
        
        int digitCount = 0;
        while(tokenizer.hasMoreTokens()) {
            tokenizer.nextToken();
            digitCount++;
        }
        
        return digitCount == 10;
    }
    
    // Using StringBuffer for dynamic bill summary
    public static StringBuffer buildBillSummary(double subtotal, double gst, double discount, 
                                                 double total, String paymentMethod, boolean freeSunglasses) {
        StringBuffer summary = new StringBuffer();
        
        summary.append("\n─────────── BILLING SUMMARY ───────────\n");
        summary.append(String.format("Subtotal: Rs.%.2f\n", subtotal));
        summary.append(String.format("GST (8%%): Rs.%.2f\n", gst));
        summary.append(String.format("Total: Rs.%.2f\n", subtotal + gst));
        summary.append(String.format("Discount: - Rs.%.2f\n", discount));
        summary.append("───────────────────────────────────────\n");
        summary.append(String.format("FINAL AMOUNT: Rs.%.2f\n", total));
        summary.append("───────────────────────────────────────\n");
        summary.append("Payment Method: ").append(paymentMethod).append("\n");
        
        if(freeSunglasses) {
            summary.append("\n CONGRATULATIONS! \n");
            summary.append("You get FREE SUNGLASSES worth Rs.1800!\n");
        }
        
        return summary;
    }
    
    // Lambda expression for text formatting
    public static TextFormatter toUpperCase = (text) -> text.toUpperCase();
    public static TextFormatter addBorder = (text) -> "*** " + text + " ***";
    
    //FunctionalInterface
    public interface TextFormatter {
        String format(String text);
    }
}