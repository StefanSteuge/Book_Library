package entity;

import java.util.Objects;
import java.util.UUID;

public class Book {

    private UUID id;
    private String name;
    private String author;
    private String borrower;
    private BookStatus status;

    public Book(UUID id, String name, String author, BookStatus status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(borrower, book.borrower) && status == book.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, borrower, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status  +
                '}' + "\n";
    }
}
