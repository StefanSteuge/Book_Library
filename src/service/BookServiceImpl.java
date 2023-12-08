package service;

import entity.Book;
import exception.NotFoundException;
import repositories.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static entity.BookStatus.BORROWED;
import static entity.BookStatus.IN_STOCK;
import static exception.ExceptionConstants.ILLEGAL_ARGUMENT_MESSAGE;
import static exception.ExceptionConstants.NOT_FOUND_BOOK_BY_ID;
import static exception.ExceptionConstants.NOT_FOUND_MESSAGE;
import static exception.ExceptionConstants.NOT_FOUND_THE_READER;
import static util.Constants.ADD_BOOK_MESSAGE;
import static util.Constants.BORROW_BOOK_MESSAGE;

public class BookServiceImpl implements BookService {

    private final DB db = new DB();

    public void createBook(String bookInfo) {
        if (bookInfo.isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        String[] parts = bookInfo.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException(ADD_BOOK_MESSAGE);
        }

        String name = parts[0].trim();
        String author = parts[1].trim();
        if (name.isEmpty() || author.isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        Book book = new Book(UUID.randomUUID(), name, author, IN_STOCK);
        db.getBooks().add(book);
    }

    public void getAllBooks() {
        if (db.getBooks() == null) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
        System.out.println(db.getBooks() + "\n");
    }

    public void borrowBookById(String requiredInfo) {
        String[] parts = requiredInfo.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException(BORROW_BOOK_MESSAGE);
        }

        var bookId = parts[0].trim();
        var readerId = parts[1].trim();

        var book = db.getBooks().stream()
                .filter(e -> e.getId().equals(UUID.fromString(bookId)))
                .findFirst().orElseThrow(() -> new NotFoundException(NOT_FOUND_BOOK_BY_ID));

        var reader = db.getReaders().stream()
                .filter(e -> e.getId().equals(UUID.fromString(readerId)))
                .findFirst().orElseThrow(() -> new NotFoundException(NOT_FOUND_THE_READER));

        book.setBorrower(String.valueOf(reader));
        book.setStatus(BORROWED);
    }

    @Override
    public void returnBookToTheLibrary(String bookId) {
        Book returnedBook = db.getBooks().stream()
                .filter(e -> e.getId().equals(UUID.fromString(bookId)))
                .findFirst().orElseThrow(() -> new NotFoundException(NOT_FOUND_BOOK_BY_ID));

        returnedBook.setStatus(IN_STOCK);
    }

    @Override
    public void showAllBorrowedBook(String readerId) {
        if (readerId != null) {
            List<Book> borrowedBooks = db.getBooks().stream()
                    .filter(e -> e.getBorrower().equals(readerId))
                    .toList();
            System.out.println(borrowedBooks);
        }else{
            throw new NotFoundException(NOT_FOUND_THE_READER);
        }
    }

}
