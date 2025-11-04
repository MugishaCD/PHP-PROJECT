class SoilAnalysis {
    private String farmerid;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;

    public SoilAnalysis(String farmerid, String districtName, double nitrogenLevel, double phosphorusLevel,
                        double potassiumLevel, String cropType) {
        this.farmerid = farmerid;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public String getDistrictName() {
        return districtName;
    }

    public double getNitrogenLevel() {
        return nitrogenLevel;
    }

    public double getPhosphorusLevel() {
        return phosphorusLevel;
    }

    public double getPotassiumLevel() {
        return potassiumLevel;
    }

    public String getCropType() {
        return cropType;
    }

    public boolean isBalanced() {
        return nitrogenLevel >= 20 && nitrogenLevel <= 100 &&
                phosphorusLevel >= 20 && phosphorusLevel <= 100 &&
                potassiumLevel >= 20 && potassiumLevel <= 100;
    }

    public String calculateFertilizerNeeded() {
        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading");
        }

        StringBuilder deficient = new StringBuilder();
        StringBuilder excess = new StringBuilder();

        if (nitrogenLevel < 20) deficient.append("Nitrogen ");
        if (phosphorusLevel < 20) deficient.append("Phosphorus ");
        if (potassiumLevel < 20) deficient.append("Potassium ");

        if (nitrogenLevel > 100) excess.append("Nitrogen ");
        if (phosphorusLevel > 100) excess.append("Phosphorus ");
        if (potassiumLevel > 100) excess.append("Potassium ");

        if (isBalanced()) {
            return "Optimal-Maintanance fertilizer only";
        } else if (deficient.length() > 0) {
            return "DEFICIENT-High application needed for " + deficient.toString().trim();
        } else if (excess.length() > 0) {
            return "EXCESS- Reduce " + excess.toString().trim() + " application";
        } else {
            return "Check nutrient levels";
        }
    }
}

public class FertilizerAdvisorySystem24RP05321 {
    public static void processSamples(SoilAnalysis[] samples) {
        int balancedCount = 0;
        int deficientCount = 0;

        // Print in reverse order to start from Farmer ID:F001 to F005
        for (int i = samples.length - 1; i >= 0; i--) {
            SoilAnalysis sample = samples[i];
            try {
                System.out.println("Farmer ID:" + sample.getFarmerid());
                System.out.println("District:" + sample.getDistrictName());
                System.out.println("Crop Type:" + sample.getCropType());
                String recommendation = sample.calculateFertilizerNeeded();
                System.out.println("Recommendation : " + recommendation + "\n");

                if (recommendation.startsWith("Optimal")) {
                    balancedCount++;
                } else if (recommendation.startsWith("DEFICIENT")) {
                    deficientCount++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Farmer ID:" + sample.getFarmerid() + " has invalid nutrient reading: " + e.getMessage() + "\n");
            }
        }

        System.out.println("Summary report");
        System.out.println("Balanced Samples :" + balancedCount);
        System.out.println("Deficient Samples:" + deficientCount);
    }

    public static void main(String[] args) {
        SoilAnalysis[] samples = {
                new SoilAnalysis("F005", "Huye", 15, 15, 18, "Rice"),      // Deficient
                new SoilAnalysis("F004", "Gashibo", -5, 40, 60, "Beans"),  // Excess
                new SoilAnalysis("F003", "Nyagatare", 110, 90, 85, "Beans"),    // Invalid (throws exception)
                new SoilAnalysis("F002", "Bugesera", 10, 45, 60, "Rice"),  // Deficient
                new SoilAnalysis("F001", "Kirehe", 50, 70, 80, "Maize")     // Balanced
        };
        processSamples(samples);
    }
}
