package entities.items;

import java.util.Objects;

public class Book extends Item {
    private String author;
    private int pages;

    public Book(int id, String title, int price, String author, int pages) {
        super(id, title, price);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    /**
     * Equals two objects.
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param obj the first term
     * @return boolean result
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(author, ((Book) obj).author)
                && pages == ((Book) obj).pages
                && super.getId() == ((Book) obj).getId()
                && super.getPrice() == ((Book) obj).getPrice()
                && Objects.equals(super.getTitle(), ((Book) obj).getTitle());
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
        return "Book{" + super.toString() + ", author='" + author + "', pages=" + pages + "}";
    }
}
