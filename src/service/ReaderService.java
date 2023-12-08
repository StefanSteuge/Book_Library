package service;

public interface ReaderService {

    void createReader(String name);

    void getAllReaders();

    void getCurrentReaderOfABook(String bookId);
}
