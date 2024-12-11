package labs.kpi.models;

import labs.kpi.annotations.*;

/**
 * Represents an article with name, price, and stock quantity.
 *
 * @author Oleksii Kyrychenko
 */
public class Article {

    @NotNull
    private String name;

    @MinValue(0)
    private int price;

    @MinValue(0)
    private int stock;

    public Article(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
