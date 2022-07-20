package entities.items;

import java.util.Objects;

public class Item {

    private int id;
    private String title;
    private int price;

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Item(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String toString() {
        return "Item{id=" + id + ", title='" + title + "', price=" + price + "}";
    }
    public boolean equals(Object obj){
        return Objects.equals(this.toString(), obj.toString());
    }


}
