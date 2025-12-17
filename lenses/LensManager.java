package lenses;
import interfaces.Selectable;
import java.util.*;
public class LensManager {
    private Scanner scanner;
    private List<Selectable> selectedItems;
    private String[] lensTypes;
    private String[] lensFeatures;
    public LensManager(Scanner scanner) {
        this.scanner = scanner;
        this.selectedItems = new ArrayList<>();
        initializeLensTypes();
        initializeLensFeatures();
    }
    private void initializeLensTypes() {
        lensTypes = new String[20];
        lensTypes[1] = "Single Vision Lenses|1500";
        lensTypes[2] = "Bifocal Lenses|2500";
        lensTypes[3] = "Progressive Lenses|3500";
        lensTypes[4] = "Toric Lenses|2800";
        lensTypes[5] = "Prism Lenses|3200";
        lensTypes[6] = "Reading Lenses|1200";
        lensTypes[7] = "High-Index Lenses|2800";
        lensTypes[8] = "Aspheric Lenses|2400";
        lensTypes[9] = "Soft Contact Lenses|1800";
        lensTypes[10] = "Multifocal Contact Lenses|3000";
        lensTypes[11] = "Colored Contact Lenses|2200";
        lensTypes[12] = "Scleral Lenses|4500";
        lensTypes[13] = "Photochromic Lenses|3800";
        lensTypes[14] = "Polarized Lenses|2600";
        lensTypes[15] = "Blue Light Lenses|2000";
        lensTypes[16] = "UV-Blocking Lenses|1800";
        lensTypes[17] = "Anti-Fatigue Lenses|2300";
        lensTypes[18] = "Anti-Glare Lenses|1900";
        lensTypes[19] = "Adaptive Lenses|4000";
    }
    
    private void initializeLensFeatures() {
        lensFeatures = new String[14];
        lensFeatures[1] = "Anti-glare|300";
        lensFeatures[2] = "Anti-reflective|400";
        lensFeatures[3] = "Blue Light Protection|500";
        lensFeatures[4] = "Photochromic|800";
        lensFeatures[5] = "Transition Lenses|900";
        lensFeatures[6] = "UV Protection|350";
        lensFeatures[7] = "Scratch Resistant|250";
        lensFeatures[8] = "Water Repellent|200";
        lensFeatures[9] = "Dust Repellent|180";
        lensFeatures[10] = "Polarized|700";
        lensFeatures[11] = "High Index|600";
        lensFeatures[12] = "Tinted Lenses|450";
        lensFeatures[13] = "Colored Lenses|550";
    }
    public void selectLenses() {
        try {
            System.out.println("\n═══ LENS TYPES ═══");
            for(int i = 1; i < lensTypes.length; i++) {
                if(lensTypes[i] != null) {
                    String[] parts = lensTypes[i].split("\\|");
                    System.out.println(i + ". " + parts[0] + " - ₹" + parts[1]);
                }
            }
            System.out.print("\nSelect lens type (1-19): ");
            int lensChoice = scanner.nextInt();
            scanner.nextLine();
            if(lensChoice < 1 || lensChoice >= lensTypes.length || lensTypes[lensChoice] == null) {
                throw new InvalidLensException("Invalid lens type selected!");
            }
            String[] lensData = lensTypes[lensChoice].split("\\|");
            String lensName = lensData[0];
            double lensPrice = Double.parseDouble(lensData[1]);
            System.out.println("\n═══ LENS FEATURES ═══");
            for(int i = 1; i < lensFeatures.length; i++) {
                if(lensFeatures[i] != null) {
                    String[] parts = lensFeatures[i].split("\\|");
                    System.out.println(i + ". " + parts[0] + " - ₹" + parts[1]);
                }
            }
            System.out.println("0. No additional feature");
            System.out.print("\nSelect feature (0-13): ");
            int featureChoice = scanner.nextInt();
            scanner.nextLine();
            StandardLens lens;
            if(featureChoice == 0) {
                lens = new StandardLens(lensName, lensPrice);
            } else if(featureChoice > 0 && featureChoice < lensFeatures.length && lensFeatures[featureChoice] != null) {
                String[] featureData = lensFeatures[featureChoice].split("\\|");
                String featureName = featureData[0];
                double featurePrice = Double.parseDouble(featureData[1]);
                lens = new StandardLens(lensName, lensPrice, featureName, featurePrice);
            } else {
                throw new InvalidLensException("Invalid feature selected!");
            }
            selectedItems.add(lens);
            System.out.println("\n✓ Lens added successfully!");
        } catch(InvalidLensException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Invalid input! " + e.getMessage());
        }
    }
    public List<Selectable> getSelectedItems() {
        return selectedItems;
    }
}