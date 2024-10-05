abstract class iPhone implements Cloneable {
    private String model;
    private String storage;
    private double price;

    public iPhone(String model, String storage, double price) {
        this.model = model;
        this.storage = storage;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getStorage() {
        return storage;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public iPhone clone() {
        try {
            return (iPhone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}
class iPhone15 extends iPhone {
    public iPhone15() {
        super("iPhone 15", "128 GB", 504990);
    }
}
