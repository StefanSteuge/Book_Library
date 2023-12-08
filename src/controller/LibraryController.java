package controller;

import service.BookServiceImpl;
import service.ReaderServiceImpl;

import java.util.Scanner;

import static util.Constants.ADD_BOOK_MESSAGE;
import static util.Constants.BORROW_BOOK_MESSAGE;
import static util.Constants.GREETING;
import static util.Constants.MESSAGE_TO_THE_READERS;
import static util.Constants.FINALE_MESSAGE;
import static util.Constants.REGISTER_READER_MESSAGE;
import static util.Constants.SHOW_CURRENT_READER;

public class LibraryController {

    ReaderServiceImpl readerServiceImpl = new ReaderServiceImpl();
    BookServiceImpl bookServiceImpl = new BookServiceImpl();

    public void run() {
        System.out.println(GREETING);
        System.out.println(MESSAGE_TO_THE_READERS);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String bookId = scanner.nextLine();
        String readerId = scanner.nextLine();

        while (!input.equalsIgnoreCase("exit")) {
            switch (input) {
                case "1" -> bookServiceImpl.getAllBooks();
                case "2" -> readerServiceImpl.getAllReaders();
                case "3" -> {
                    System.out.println(REGISTER_READER_MESSAGE);
                    readerServiceImpl.createReader(scanner.nextLine());}
                case "4" ->{
                        System.out.println(ADD_BOOK_MESSAGE);
                        bookServiceImpl.createBook(scanner.nextLine());}
                case "5" -> {
                        System.out.println(BORROW_BOOK_MESSAGE);
                        bookServiceImpl.borrowBookById(scanner.nextLine());}
                case "6" -> bookServiceImpl.returnBookToTheLibrary(bookId);
                case "7" -> bookServiceImpl.showAllBorrowedBook(readerId);
                case "8" -> {
                        System.out.println(SHOW_CURRENT_READER);
                        readerServiceImpl.getCurrentReaderOfABook(bookId);}
            }
            System.out.println(MESSAGE_TO_THE_READERS);
            input = scanner.nextLine();
        }
        System.out.println(FINALE_MESSAGE);
    }
}
