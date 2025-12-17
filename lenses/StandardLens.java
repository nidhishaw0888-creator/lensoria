package lenses;

public class StandardLens extends LensType {
    private String feature;
    private double featurePrice;
    
    public StandardLens(String typeName, double basePrice) {
        super(typeName, basePrice);
        this.feature = "None";
        this.featurePrice = 0.0;
    }
    
    public StandardLens(String typeName, double basePrice, String feature, double featurePrice) {
        super(typeName, basePrice);
        this.feature = feature;
        this.featurePrice = featurePrice;
    }
    
    @Override
    public void selectItem() {
        System.out.println("Selected: " + typeName);
    }
    
    @Override
    public double calculatePrice() {
        return basePrice + featurePrice;
    }
    
    @Override
    public String getItemDescription() {
        if(feature.equals("None")) {
            return typeName + " - Rs." + basePrice;
        }
        return typeName + " with " + feature + " - Rs." + calculatePrice();
    }
}