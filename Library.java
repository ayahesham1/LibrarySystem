import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String address;
    private List<Book> books;

    // Constructor to initialize the library with a name and address
    public Library(String name, String address) {
        setName(name);
        setAddress(address);
        this.books = new ArrayList<>();  // Using ArrayList for dynamic sizing
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Setters with validation based on length constraints
    public void setName(String name) {
        if (name.length() >= 9 && name.length() <= 20) {
            this.name = name;
        }
    }

    public void setAddress(String address) {
        if (address.length() >= 10 && address.length() <= 25) {
            this.address = address;
        }
    }

    // Method to retrieve the list of available books in the library
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book != null && "Available".equals(book.getStatus())) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // Adds a book to the library only if the book is available
    public boolean addBook(Book book) {
        if (book != null && "Available".equals(book.getStatus())) {
            books.add(book);
            return true;
        }
        return false;
    }

    // Removes a book from the library if it's archived
    public boolean removeBook(Book book) {
        if (book != null && "Archived".equals(book.getStatus())) {
            return books.remove(book);
        }
        return false;
    }

    // Rents a book to a reader if it's available
    public boolean rentBook(int index, Reader reader) {
        if (index >= 0 && index < books.size()) {
            Book bookToRent = books.get(index);
            if (bookToRent != null && "Available".equals(bookToRent.getStatus()) && reader != null) {
                bookToRent.rent(reader);
                bookToRent.setStatus("Rented");
                return true;
            }
        }
        return false;
    }

    // Returns a book and updates its rating
    public boolean returnBook(Book book, int rating) {
        if (book != null && "Rented".equals(book.getStatus())) {
            book.setStatus("Available");
            if (rating > 0) {
                book.addRating(book.getLastReader(), rating);
            }
            return true;
        }
        return false;
    }

    // Method to display library summary
    @Override
    public String toString() {
        List<Book> availableBooks = getAvailableBooks();
        int availableCount = availableBooks.size();

        if (availableCount == 0) {
            return "Library " + name + " has 0 books available";
        } else if (availableCount == 1) {
            return "Library " + name + " has 1 book available";
        } else {
            return "Library " + name + " has " + availableCount + " books available";
        }
    }

    // Displays a list of all books in the library
    public String displayBooks() {
        StringBuilder result = new StringBuilder("List of books:\n");

        for (Book book : books) {
            if (book != null) {
                result.append(String.format("\t\"%s\" by %s (%d) -- Rating: %.1f -- %s%n",
                        book.getTitle(), book.getAuthor(), book.getPublicationYear(),
                        book.getRating(), book.getStatus()));
            }
        }

        return result.toString();
    }
}
