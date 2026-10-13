package FunctionalProgramingJava.Intermediate;

public class Book {

    public String title;
    public int publicationYear;
    public String author;
    public double price;
    public String category;

    public Book(String title, int publicationYear, String author, double price, String category) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.price = price;
        this.category = category;
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }



}
