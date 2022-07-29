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

    /**
     * Returns string with data about item
     *
     * n=title length
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @return string
     */

    public String toString() {
        return "Item{id=" + id + ", title='" + title + "', price=" + price + "}";
    }

    /**
     * Equals two objects
     * @cpu O(1)
     * @ram O(1)
     * @param obj the first term
     * @return result of equals two objects
     */

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return Objects.equals(this, obj);
    }


}
