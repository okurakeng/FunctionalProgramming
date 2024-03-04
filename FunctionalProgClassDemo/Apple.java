public class Apple {
    private double weight = 0;
    private String color = "";
    private int numberSeeds = 0;
    private boolean isPoisonous = false;

    public Apple(Double weight, String color, int numberSeeds, boolean isPoisonous) {
        this.weight = weight;
        this.color = color;
        this.numberSeeds = numberSeeds;
        this.isPoisonous = isPoisonous;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberSeeds() {
        return numberSeeds;
    }

    public void setNumberSeeds(int numberSeeds) {
        this.numberSeeds = numberSeeds;
    }

    public boolean getIsPoisonous() {
        return isPoisonous;
    }

    public void setIsPoisonous(boolean isPoisonous) {
        this.isPoisonous = isPoisonous;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", seeds=" + numberSeeds +
                ", isPoisonous=" + isPoisonous +
                '}';
    }
}
