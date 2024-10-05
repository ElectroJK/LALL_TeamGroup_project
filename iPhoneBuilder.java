class iPhoneBuilder {
    private String model;
    private String storage;
    private double price;

    public iPhoneBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public iPhoneBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public iPhoneBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public iPhone build() {
        if ("iPhone 15".equals(model)) {
            return new iPhone15();
        }
         else {
            throw new IllegalArgumentException("Unknown iPhone model: " + model);
        }
    }
}
