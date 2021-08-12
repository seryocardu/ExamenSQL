import java.util.HashSet;
import java.util.Set;

public class Pizza extends Entity {

    private String name;
    private double price;
    private String url;
    private final Set<Ingredients> ingredients = new HashSet<Ingredients>();
    private final Set<Comment> comment = new HashSet<Comment>();

    public Pizza(String name, double price) {

        super();
        this.name = name;
        this.price = price;
    }

    public void validate() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        for (Ingredients in : ingredients) {
            this.price += in.getPrices();
        }
        this.price = 1.2 * this.price;
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Ingredients> getIngredients() {
        return this.ingredients;
    }

    public Set<Comment> getComment() {
        return this.comment;
    }

    public String getUrl() {
        return this.url;
    }

}