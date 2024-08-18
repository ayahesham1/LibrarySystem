import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private float rating;
    private long isbn;
    private String status;
    private List<Reader> readersHistory;
    private List<Integer> ratingsHistory;

    // Constructor to initialize book properties
    public Book(String title, String author, int publicationYear, long isbn) {
        setTitle(title);
        setAuthor(author);
        setPublicationYear(publicationYear);
        setIsbn(isbn);
        this.status = "Available"; // Set initial status
        this.readersHistory = new ArrayList<>();
        this.ratingsHistory = new ArrayList<>();
    }

    // Setters with validation
    public void setTitle(String title) {
        if (title != null && title.length() > 2) {
            this.title = title;
        }
    }

    public void setAuthor(String author) {
        if (author != null && author.length() > 5) {
            this.author = author;
        }
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear >= 1700 && publicationYear <= 2023) {
            this.publicationYear = publicationYear;
        }
    }

    public void setIsbn(long isbn) {
        String isbnStr = String.valueOf(isbn);
        if ((publicationYear < 2007 && isbnStr.length() == 10) || (publicationYear >= 2007 && isbnStr.length() == 13)) {
            this.isbn = isbn;
        }
    }

    public void setStatus(String status) {
        if (status != null && (status.equals("Available") || status.equals("Rented") || status.equals("Archived"))) {
            this.status = status;
        }
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public float getRating() {
        return rating;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getStatus() {
        return status;
    }

    // Archive book if available
    public boolean archive() {
        if ("Available".equals(status)) {
            status = "Archived";
            return true;
        }
        return false;
    }

    // Rent book if available
    public boolean rent(Reader reader) {
        if ("Available".equals(status)) {
            readersHistory.add(reader);
            setStatus("Rented");
            return true;
        }
        return false;
    }

    // Get last reader
    public Reader getLastReader() {
        if (readersHistory.isEmpty()) {
            return null;
        }
        return readersHistory.get(readersHistory.size() - 1);
    }

    // Add a rating from a reader
    public boolean addRating(Reader reader, int rating) {
        if (readersHistory.contains(reader)) {
            int readerIndex = readersHistory.lastIndexOf(reader);
            if (readerIndex < ratingsHistory.size()) {
                ratingsHistory.set(readerIndex, rating);
            } else {
                ratingsHistory.add(rating);
            }
            updateRating();
            return true;
        }
        return false;
    }

    // Update average rating
    private void updateRating() {
        int totalRatings = 0;
        int validRatingsCount = 0;

        for (int rate : ratingsHistory) {
            if (rate > 0) {
                totalRatings += rate;
                validRatingsCount++;
            }
        }

        if (validRatingsCount > 0) {
            this.rating = (float) totalRatings / validRatingsCount;
        }
    }

    // String representation of the book
    @Override
    public String toString() {
        return String.format("\"%s\" by %s (%d) - Rating: %.1f - %s", title, author, publicationYear, rating, status);
    }
}
