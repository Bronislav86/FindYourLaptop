public class Laptop {
    String colour;
    String brand;
    String CPUtype;
    Integer amountOfRAM;
    Integer displaySize;
    Integer amountOfHDD;

    @Override
    public String toString() {
        return "Brand: " + brand + ", Colour: " + colour + ", Display_': " + displaySize + ", CPU type: " + CPUtype + ", Amount of RAM_Gb: " + amountOfRAM + ", HDD_Gb: " + amountOfHDD;
    }

    @Override
    public int hashCode() {
        return brand.hashCode() + 5*colour.hashCode() + displaySize*11 + CPUtype.hashCode()*18 + amountOfHDD*19 + amountOfRAM*9;
    }
}

