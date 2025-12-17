package glasses;

import interfaces.Selectable;

public abstract class GlassType implements Selectable {
    protected String glassTypeName;
    protected double basePrice;
    
    public GlassType(String glassTypeName, double basePrice) {
        this.glassTypeName = glassTypeName;
        this.basePrice = basePrice;
    }
    
    public abstract double calculatePrice();
    
    public String getGlassTypeName() {
        return glassTypeName;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
}