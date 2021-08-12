public class Ingredients extends Entity {

    private double prices;
    private String name;

    public Ingredients(String name, double prices) {

        super();
        this.name = name;
        this.prices = prices;
    }

    public void validate() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double price) {
        this.prices = price;
    }
}
