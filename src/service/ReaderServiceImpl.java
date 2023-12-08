package service;

import entity.Book;
import entity.Reader;
import repositories.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static exception.ExceptionConstants.ILLEGAL_ARGUMENT_MESSAGE;
import static exception.ExceptionConstants.NOT_FOUND_MESSAGE;

public class ReaderServiceImpl implements ReaderService {

    private final DB db = new DB();

    public void createReader(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        Reader reader = new Reader(UUID.randomUUID(), name);
        db.getReaders().add(reader);
    }

    public void getAllReaders() {
        if (db.getReaders() == null) {
            System.out.println(NOT_FOUND_MESSAGE);
            return;
        }
        System.out.println(db.getReaders() + "\n");
    }

    @Override
    public void getCurrentReaderOfABook(String bookId) {
        if (!bookId.isEmpty()) {
            List<Book> books = db.getBooks();
            books.stream()
                    .filter(b -> b.getId().equals(UUID.fromString(bookId)))
                    .forEach(Book::getBorrower);
        } else {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
    }


}
