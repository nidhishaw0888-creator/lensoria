package glasses;

public final class StandardGlass extends GlassType {
    private String frameType;
    private String frameColor;
    private String feature;
    private double framePrice;
    private double featurePrice;
    private String leftEyePower;
    private String rightEyePower;
    
    public StandardGlass(String glassTypeName, double basePrice) {
        super(glassTypeName, basePrice);
        this.frameType = "Standard";
        this.frameColor = "Black";
        this.feature = "None";
        this.framePrice = 0.0;
        this.featurePrice = 0.0;
        this.leftEyePower = "N/A";
        this.rightEyePower = "N/A";
    }
    
    public StandardGlass(String glassTypeName, double basePrice, String frameType, 
                        String frameColor, String feature, double framePrice, 
                        double featurePrice, String leftEyePower, String rightEyePower) {
        super(glassTypeName, basePrice);
        this.frameType = frameType;
        this.frameColor = frameColor;
        this.feature = feature;
        this.framePrice = framePrice;
        this.featurePrice = featurePrice;
        this.leftEyePower = leftEyePower;
        this.rightEyePower = rightEyePower;
    }
    
    @Override
    public void selectItem() {
        System.out.println("Selected: " + glassTypeName);
    }
    
    @Override
    public double calculatePrice() {
        return basePrice + framePrice + featurePrice;
    }
    
    @Override
    public String getItemDescription() {
        StringBuilder desc = new StringBuilder();
        desc.append(glassTypeName);
        if(!leftEyePower.equals("N/A")) {
            desc.append(" (L: ").append(leftEyePower).append(", R: ").append(rightEyePower).append(")");
        }
        desc.append(" - ").append(frameType).append(" Frame (").append(frameColor).append(")");
        if(!feature.equals("None")) {
            desc.append(" with ").append(feature);
        }
        desc.append(" - Rs.").append(calculatePrice());
        return desc.toString();
    }
}