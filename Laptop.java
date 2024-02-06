public class Laptop {
    String colour;
    String brand;
    Integer CPUtype;
    Integer amountOfRAM;
    Integer displaySize;

    @Override
    public String toString() {
        return "Brand: " + brand + ", Colour: " + colour + ", Display, \": " + displaySize + ", CPU type: " + CPUtype + ", Amount of RAM: " + amountOfRAM;
    }
}

