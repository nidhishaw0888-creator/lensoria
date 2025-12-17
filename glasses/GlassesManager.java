package glasses;

import interfaces.Selectable;
import java.util.*;
public class GlassesManager {
    private Scanner scanner;
    private List<Selectable> selectedItems;
    private String[] glassTypes;
    private String[] frameTypes;
    private String[] frameColors;
    private String[] frameFeatures;
    public GlassesManager(Scanner scanner) {
        this.scanner = scanner;
        this.selectedItems = new ArrayList<>();
        initializeGlassTypes();
        initializeFrameTypes();
        initializeFrameColors();
        initializeFrameFeatures();
    }
    private void initializeGlassTypes() {
        glassTypes = new String[12];
        glassTypes[1] = "Power Glasses|2000|power";
        glassTypes[2] = "Kids Glasses|1500|none";
        glassTypes[3] = "Sun Glasses|1800|none";
        glassTypes[4] = "Fashion Glasses|1200|none";
        glassTypes[5] = "Reading Glasses|1000|none";
        glassTypes[6] = "Screen/Blue Light Glasses|2200|none";
        glassTypes[7] = "Sports/Protective Glasses|2500|none";
        glassTypes[8] = "Photochromic Glasses|3500|none";
        glassTypes[9] = "Trifocal Glasses|3200|none";
        glassTypes[10] = "Bifocal Glasses|2800|none";
        glassTypes[11] = "3D Glasses|800|none";
    }
    private void initializeFrameTypes() {
        frameTypes = new String[19];
        frameTypes[1] = "Full-Rim|500";
        frameTypes[2] = "Half-Rim|600";
        frameTypes[3] = "Rimless|800";
        frameTypes[4] = "Sports|700";
        frameTypes[5] = "Safety|650";
        frameTypes[6] = "Metal|550";
        frameTypes[7] = "Plastic|400";
        frameTypes[8] = "TR90|750";
        frameTypes[9] = "Titanium|1200";
        frameTypes[10] = "Combination|900";
        frameTypes[11] = "Round|500";
        frameTypes[12] = "Oval|500";
        frameTypes[13] = "Square|500";
        frameTypes[14] = "Rectangular|500";
        frameTypes[15] = "Cat-Eye|600";
        frameTypes[16] = "Wayfarer|700";
        frameTypes[17] = "Aviator|800";
        frameTypes[18] = "Geometric|650";
    }
    
    private void initializeFrameColors() {
        frameColors = new String[29];
        frameColors[1] = "Black";
        frameColors[2] = "Brown";
        frameColors[3] = "Tortoise Shell";
        frameColors[4] = "Grey";
        frameColors[5] = "Gunmetal";
        frameColors[6] = "Transparent";
        frameColors[7] = "Crystal";
        frameColors[8] = "White";
        frameColors[9] = "Silver";
        frameColors[10] = "Golden";
        frameColors[11] = "Rose Gold";
        frameColors[12] = "Red";
        frameColors[13] = "Blue";
        frameColors[14] = "Navy Blue";
        frameColors[15] = "Green";
        frameColors[16] = "Purple";
        frameColors[17] = "Violet";
        frameColors[18] = "Pink";
        frameColors[19] = "Rose Pink";
        frameColors[20] = "Yellow";
        frameColors[21] = "Mustard";
        frameColors[22] = "Black-Gold";
        frameColors[23] = "Blue-Transparent";
        frameColors[24] = "Brown-Gradient";
        frameColors[25] = "Ombre";
        frameColors[26] = "Multi Color";
        frameColors[27] = "Hazel";
        frameColors[28] = "Turquoise";
    }
    private void initializeFrameFeatures() {
        frameFeatures = new String[9];
        frameFeatures[1] = "Anti-glare|300";
        frameFeatures[2] = "Blue Light Protection|500";
        frameFeatures[3] = "UV Protection|350";
        frameFeatures[4] = "Scratch Resistant|250";
        frameFeatures[5] = "Polarized|700";
        frameFeatures[6] = "Transition|800";
        frameFeatures[7] = "Lightweight Frame|400";
        frameFeatures[8] = "Flexible Frame|450";
    }
    public void selectGlasses() {
        try {
            System.out.println("\n═══ GLASS TYPES ═══");
            for(int i = 1; i < glassTypes.length; i++) {
                if(glassTypes[i] != null) {
                    String[] parts = glassTypes[i].split("\\|");
                    System.out.println(i + ". " + parts[0] + " - ₹" + parts[1]);
                }
            }
            System.out.print("\nSelect glass type (1-11): ");
            int glassChoice = scanner.nextInt();
            scanner.nextLine();
            if(glassChoice < 1 || glassChoice >= glassTypes.length || glassTypes[glassChoice] == null) {
                throw new InvalidGlassException("Invalid glass type selected!");
            }
            String[] glassData = glassTypes[glassChoice].split("\\|");
            String glassName = glassData[0];
            double glassPrice = Double.parseDouble(glassData[1]);
            boolean needsPower = glassData[2].equals("power");
            String leftEyePower = "N/A";
            String rightEyePower = "N/A";
            if(needsPower) {
                System.out.print("Enter left eye power (e.g., -2.5, +1.0): ");
                leftEyePower = scanner.nextLine();
                System.out.print("Enter right eye power (e.g., -2.5, +1.0): ");
                rightEyePower = scanner.nextLine();
            }
            System.out.println("\n═══ FRAME TYPES ═══");
            for(int i = 1; i < frameTypes.length; i++) {
                if(frameTypes[i] != null) {
                    String[] parts = frameTypes[i].split("\\|");
                    System.out.println(i + ". " + parts[0] + " - ₹" + parts[1]);
                }
            }
            System.out.print("\nSelect frame type (1-18): ");
            int frameChoice = scanner.nextInt();
            scanner.nextLine();
            if(frameChoice < 1 || frameChoice >= frameTypes.length || frameTypes[frameChoice] == null) {
                throw new InvalidGlassException("Invalid frame type selected!");
            }
            String[] frameData = frameTypes[frameChoice].split("\\|");
            String frameName = frameData[0];
            double framePrice = Double.parseDouble(frameData[1]);
            System.out.println("\n═══ FRAME COLORS ═══");
            displayFrameColors();
            System.out.print("\nSelect frame color (1-28): ");
            int colorChoice = scanner.nextInt();
            scanner.nextLine();
            if(colorChoice < 1 || colorChoice >= frameColors.length || frameColors[colorChoice] == null) {
                throw new InvalidGlassException("Invalid color selected!");
            }
            String colorName = frameColors[colorChoice];
            System.out.println("\n═══ FRAME FEATURES ═══");
            for(int i = 1; i < frameFeatures.length; i++) {
                if(frameFeatures[i] != null) {
                    String[] parts = frameFeatures[i].split("\\|");
                    System.out.println(i + ". " + parts[0] + " - ₹" + parts[1]);
                }
            }
            System.out.println("0. No additional feature");
            System.out.print("\nSelect feature (0-8): ");
            int featureChoice = scanner.nextInt();
            scanner.nextLine();
            String featureName = "None";
            double featurePrice = 0.0;
            if(featureChoice != 0) {
                if(featureChoice < 1 || featureChoice >= frameFeatures.length || frameFeatures[featureChoice] == null) {
                    throw new InvalidGlassException("Invalid feature selected!");
                }
                String[] featureData = frameFeatures[featureChoice].split("\\|");
                featureName = featureData[0];
                featurePrice = Double.parseDouble(featureData[1]);
            }
            StandardGlass glass = new StandardGlass(glassName, glassPrice, frameName, 
                                                   colorName, featureName, framePrice, 
                                                   featurePrice, leftEyePower, rightEyePower);
            
            selectedItems.add(glass);
            System.out.println("\n✓ Glasses added successfully!");
            
        } catch(InvalidGlassException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Invalid input! " + e.getMessage());
        }
    }
    private void displayFrameColors() {
        int count = 0;
        
        for(int i = 1; i < frameColors.length; i++) {
            if(frameColors[i] != null) {
                System.out.print(i + ". " + frameColors[i] + "  ");
                count++;
                if(count % 4 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
    public List<Selectable> getSelectedItems() {
        return selectedItems;
    }
}