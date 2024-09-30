abstract class iPhone {
    private String model;
    private String storage;
    private double price;

    public iPhone(String model,String storage, double price){
        this.model=model;
        this.storage=storage;
        this.price=price;
    }

    public String getModel(){
        return model;
    }
    public String getStorage(){
        return storage;
    }
    public double getPrice(){
        return price;
    }
}

class iPhone15 extends iPhone {
    public iPhone15() {
        super("Iphone 15", "128 GB", 504990);
    }
}
