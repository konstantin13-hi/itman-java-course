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
     * Returns string with data about item.
     * n=title length
     *
     * @return string
     * @cpu O(n)
     * @ram O(n)
     */

    public String toString() {
        return "Item{id=" + id + ", title='" + title + "', price=" + price + "}";
    }

    /**
     * Equals two objects.
     * n=Tittle's length
     *
     * @param obj the first term
     * @return result of equals two objects
     * @cpu O(n)
     * @ram O(1)
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Item that = (Item) obj;
        return id == that.id && Objects.equals(title, that.title)
                && price == that.price;
    }


}
