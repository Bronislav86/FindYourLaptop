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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getAmountOfHDD() {
        return amountOfHDD;
    }

    public void setAmountOfHDD(Integer amountOfHDD) {
        this.amountOfHDD = amountOfHDD;
    }

    public Integer getAmountOfRAM() {
        return amountOfRAM;
    }

    public void setAmountOfRAM(Integer amountOfRAM) {
        this.amountOfRAM = amountOfRAM;
    }

    public String getCPUtype() {
        return CPUtype;
    }

    public void setCPUtype(String cPUtype) {
        CPUtype = cPUtype;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public Integer getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Integer displaySize) {
        this.displaySize = displaySize;
    }
}

