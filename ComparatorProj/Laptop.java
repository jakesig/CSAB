public class Laptop {
    private String brand;
    private int memory;
    private double price;

    public Laptop(String brand, int memory, double price) {
        this.brand = brand;
        this.memory = memory;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getMemory() {
        return memory;
    }

    public double getPrice() {
        return price;
    }

    @Override public String toString() {
        return  "Brand:  " + brand +
                "\tMemory:  " + memory + " GB" +
                "\tPrice:  $" + price;
    }
}
