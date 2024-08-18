public class Reader {

    private String fullName;
    private int yearOfBirth;
    private String zipCode;

    // Default constructor
    public Reader() {
        this.fullName = "Unknown";
        this.yearOfBirth = 2000;
        this.zipCode = "00000"; // Default zip code
    }

    // Constructor that initializes Reader with provided values and validates them
    public Reader(String fullName, int yearOfBirth, String zipCode) {
        this(); // Call default constructor to set default values
        setFullName(fullName);
        setYearOfBirth(yearOfBirth);
        setZipCode(zipCode);
    }

    // Getter methods
    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getZipCode() {
        return zipCode;
    }

    // Setter methods with validation
    public void setFullName(String fullName) {
        if (fullName != null && fullName.length() > 3 && fullName.length() <= 20) {
            this.fullName = fullName;
        } else {
            System.out.println("Invalid full name. It must be between 4 and 20 characters.");
        }
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth >= 1923 && yearOfBirth <= 2013) {
            this.yearOfBirth = yearOfBirth;
        } else {
            System.out.println("Invalid year of birth. It must be between 1923 and 2013.");
        }
    }

    public void setZipCode(String zipCode) {
        if (zipCode != null && zipCode.matches("\\d{5}")) { // Ensures zip code is a 5-digit string
            this.zipCode = zipCode;
        } else {
            System.out.println("Invalid zip code. It must be exactly 5 digits.");
        }
    }

    // Utility method to print reader details
    public String displayReaderInfo() {
        return String.format("Reader: %s (Born: %d), Zip Code: %s", fullName, yearOfBirth, zipCode);
    }

    // Main method for testing
    public static void main(String[] args) {
        Reader reader1 = new Reader("John Doe", 1990, "12345");
        System.out.println(reader1.displayReaderInfo());

        Reader reader2 = new Reader("Sam", 2020, "ABCDE"); // Invalid case to trigger validation
        System.out.println(reader2.displayReaderInfo());

        Reader reader3 = new Reader("Jane Smith", 1975, "54321");
        System.out.println(reader3.displayReaderInfo());
    }
}
