package repositories;

import entity.Book;
import entity.Reader;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private final List<Reader> readers = new ArrayList<>();

    private final List<Book> books = new ArrayList<>();

    public List<Reader> getReaders() {
        return readers;
    }

    public List<Book> getBooks() {
        return books;
    }
}
