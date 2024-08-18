# Library Management System

This project is a simple **Library Management System** implemented in Java, consisting of three core classes: `Reader`, `Book`, and `Library`. The system allows managing a collection of books, tracking readers, and performing library operations like adding/removing books, renting, and returning books with ratings.

## Project Overview

### **Classes**

1. **Reader**: Represents a reader, storing details like their name, year of birth, and zip code, with validation to ensure correct data entry.
2. **Book**: Manages information about a book, including title, author, publication year, ISBN, status, and ratings. It supports renting and archiving.
3. **Library**: Manages a collection of books, handling operations like adding/removing books, checking availability, and tracking rentals and returns.

## Class Details

### 1. **Reader Class**

The `Reader` class is responsible for handling information about a reader:

- **Attributes**:
  - `fullName`: The reader’s full name (must be between 4 and 20 characters).
  - `yearOfBirth`: The reader’s year of birth (must be between 1923 and 2013).
  - `zipCode`: A 5-digit string representing the reader’s zip code.
  
- **Methods**:
  - `Reader(String fullName, int yearOfBirth, String zipCode)`: Initializes a reader with validated input.
  - `setFullName(String fullName)`, `setYearOfBirth(int yearOfBirth)`, `setZipCode(String zipCode)`: Setter methods with validation for each attribute.
  - `getFullName()`, `getYearOfBirth()`, `getZipCode()`: Getter methods for retrieving the reader’s information.
  - `displayReaderInfo()`: Returns a formatted string displaying the reader’s information.
 
### 2. **Book Class**

The `Book` class manages information about individual books in the library:

#### **Attributes**:
- `title`: The title of the book.
- `author`: The author of the book (must be between 5 and 20 characters).
- `publicationYear`: The year the book was published (must be between 1700 and 2023).
- `isbn`: The book’s ISBN (10 digits for pre-2007 books, 13 digits for post-2007 books).
- `status`: The status of the book (Available, Rented, or Archived).
- `rating`: The average rating of the book from readers.
- `readersHistory`: A history of readers who rented the book.

#### **Methods**:
- `Book(String title, String author, int publicationYear, long isbn)`: Initializes a book with the given details.
- `setTitle(String title)`, `setAuthor(String author)`, `setPublicationYear(int year)`, `setIsbn(long isbn)`: Setter methods with validation.
- `getTitle()`, `getAuthor()`, `getPublicationYear()`, `getStatus()`, `getRating()`: Getter methods for retrieving book details.
- `rent(Reader reader)`: Rents the book to a reader if available.
- `archive()`: Archives the book if it is available.
- `addRating(Reader reader, int rating)`: Adds a rating for the book from a reader.
- `toString()`: Returns a string representation of the book.

### 3. **Library Class**

The `Library` class manages a collection of books and performs operations like adding, removing, and renting books.

#### **Attributes**:
- `name`: The name of the library (must be between 9 and 20 characters).
- `address`: The address of the library (must be between 10 and 25 characters).
- `books`: A list of `Book` objects representing the library’s collection.

#### **Methods**:
- `Library(String name, String address)`: Initializes the library with a name and address.
- `addBook(Book book)`: Adds a book to the library’s collection if available.
- `removeBook(Book book)`: Removes a book from the library if it is archived.
- `rentBook(int index, Reader reader)`: Rents a book to a reader if available.
- `returnBook(Book book, int rating)`: Returns a rented book and adds a rating from the reader.
- `getAvailableBooks()`: Returns a list of available books in the library.
- `toString()`: Returns a summary of available books in the library.
- `displayBooks()`: Displays a detailed list of all books in the library.

#### **Example**:
```java
Library library = new Library("Central Library", "123 Library St.");
Book book = new Book("Java Programming", "John Doe", 2010, 1234567890123L);
library.addBook(book);
System.out.println(library.displayBooks());


**Example**:
```java
Book book = new Book("Java Programming", "John Doe", 2010, 1234567890123L);
book.rent(reader);
System.out.println(book);


**Example:**
```java
Reader reader = new Reader("Alice Johnson", 1985, "12345");
System.out.println(reader.displayReaderInfo());
