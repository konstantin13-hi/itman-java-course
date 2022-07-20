package entities.items;

public class Book extends Item {
    private String author;
    private int pages;

    public Book(int id, String title, int price, String author, int pages) {
        super(id, title, price);
        this.author = author;
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }

    public String toString(){
       return "Book{"+super.toString()+", author='"+author+"', pages="+pages+"}";
   }
}
