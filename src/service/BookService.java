package service;

public interface BookService {

   void createBook(String bookInfo);

    void getAllBooks();

    void borrowBookById(String requiredInfo);

    void returnBookToTheLibrary(String bookId);

    void showAllBorrowedBook(String readerId);
}
