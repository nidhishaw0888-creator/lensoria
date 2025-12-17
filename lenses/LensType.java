package lenses;

import interfaces.Selectable;

public abstract class LensType implements Selectable {
    protected String typeName;
    protected double basePrice;
    
    public LensType(String typeName, double basePrice) {
        this.typeName = typeName;
        this.basePrice = basePrice;
    }
    
    @Override
    public abstract double calculatePrice();
    
    @Override
    public String getItemDescription() {
        return typeName + " - Rs." + basePrice;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
}