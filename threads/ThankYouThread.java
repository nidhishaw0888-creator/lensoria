package threads;

public class ThankYouThread extends Thread {
    private String customerName;
    
    public ThankYouThread(String customerName) {
        this.customerName = customerName;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            
            System.out.println("\n╔═══════════════════════════════════════════════════╗");
            System.out.println("║                                                   ║");
            System.out.println("║          THANK YOU FOR CHOOSING LENSORIA!         ║");
            System.out.println("║                                                   ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            
            Thread.sleep(500);
            
            System.out.println("\nDear " + customerName + ",");
            System.out.println("\nWe appreciate your trust in Lensoria Optics.");
            System.out.println("Your vision is our mission!");
            
            Thread.sleep(500);
            
            System.out.println("\nVisit us again soon!");
            System.out.println("Contact: +91-1800-LENSORIA");
            System.out.println("Website: www.lensoria.com");
            
            Thread.sleep(500);
            
            System.out.println("\n Rate your experience and get 10% off next time! \n");
            
        } catch(InterruptedException e) {
            System.out.println("Thank you thread interrupted: " + e.getMessage());
        }
    }
}