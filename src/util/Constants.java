package util;

public class Constants {

    public static final String GREETING = "\nWELCOME TO THE LIBRARY!\n";

    public static final String MESSAGE_TO_THE_READERS = """
            PLEASE, SELECT ONE OF THE FOLLOWING ACTIONS BY TYPING
            THE OPTION'S NUMBER AND PRESSING ENTER KEY:
            
            [1] SHOW ALL BOOKS IN THE LIBRARY
            [2] SHOW ALL READERS REGISTERED IN THE LIBRARY
            [3] REGISTER NEW READER
            [4] ADD NEW BOOK
            [5] BORROW A BOOK TO A READER
            [6] RETURN A BOOK TO THE LIBRARY
            [7] SHOW ALL BORROWED BOOK BY READER ID
            [8] SHOW CURRENT READER OF A BOOK WITH ID
            
            TYPE "EXIT" TO STOP THE PROGRAM AND EXIT!""";

    public static final String FINALE_MESSAGE = "Goodbye!";

    public static final String REGISTER_READER_MESSAGE = "Please enter new reader full name!\n";

    public static final String ADD_BOOK_MESSAGE = "Please enter new book name and author separated by '/'. Like this: name / author\n";

    public static final String BORROW_BOOK_MESSAGE = "To borrow a book user types book ID and reader ID separated by '/'.\n";

    public static final String RETURN_THE_BOOK_MESSAGE = "To return a book you need types book ID.\n";

    public static final String SHOW_ALL_BORROWED_BOOKS = "Please, enter reader Id\n";

    public static final String SHOW_CURRENT_READER = "Please, enter book Id\n";
}
