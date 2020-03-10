package hh.ohju.bookstore.Model;
import javax.persistence.JoinColumn;

import javax.persistence.*;

@Entity
public class Book {

    private String author, title, isbn;
    private Double price;
    private int year;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
        super();
        this.id = null;
        this.year = 0;
        this.price = null;
        this.author = null;
        this.title = null;
        this.isbn = null;
        this.category = null;
    }


    public Book(String author, String title, String isbn, Double price, int year, Category category) {
        super();
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.year = year;
        this.category = category;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null) {
            return "Book{" +
                    "author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", price=" + price +
                    ", year=" + year +
                    ", id=" + id +
                    ", category=" + this.category +
                    '}';
        } else {
            return "Book{" +
                    "author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", price=" + price +
                    ", year=" + year +
                    ", id=" + id +
                    '}';
        }
    }
}
