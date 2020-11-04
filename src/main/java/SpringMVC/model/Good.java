package SpringMVC.model;

public class Good {
    private int id;
    private String title;
    private Double price;

    public Good(int id, String name, Double price) {
        this.id = id;
        this.title = name;
        this.price = price;
    }

    public String getName() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}

