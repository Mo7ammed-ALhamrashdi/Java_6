package Java_6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class LibraryBookTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<Integer> bookIds = new HashSet<>();
        HashMap<Integer, String> books = new HashMap<>();
        int numberOfBooks;
        int bookId;
        int searchBookId;
        String bookTitle;
        String libraryClassification;
        System.out.println("Enter the number of books:");
        numberOfBooks = input.nextInt();
        input.nextLine();
        if (numberOfBooks <= 0) {
            System.out.println("Invalid number of books.");
        } else {
            for (int i = 1; i <= numberOfBooks; i++) {
                System.out.println("Enter Book ID " + i + ":");
                bookId = input.nextInt();
                input.nextLine();
                if (bookIds.contains(bookId)) {
                    System.out.println("Duplicate Book ID. Record not added.");
                } else {
                    System.out.println("Enter Book Title:");
                    bookTitle = input.nextLine();
                    bookIds.add(bookId);
                    books.put(bookId, bookTitle);
                }
            }
            System.out.println("Enter Book ID to search:");
            searchBookId = input.nextInt();
            if (books.containsKey(searchBookId)) {
                System.out.println("Book ID: " + searchBookId);
                System.out.println("Book Title: " + books.get(searchBookId));
            } else {
                System.out.println("Book not found.");
            }
            if (books.size() < 5) {
                libraryClassification = "Small Library";
            } else if (books.size() >= 5 && books.size() <= 10) {
                libraryClassification = "Medium Library";
            } else {
                libraryClassification = "Large Library";
            }
            System.out.println("\n Library Report ");
            System.out.println("Total Book Records Entered: " + numberOfBooks);
            System.out.println("Total Unique Books: " + bookIds.size());
            System.out.println("All Book IDs:");
            System.out.println(bookIds);
            System.out.println("Book IDs with Corresponding Titles:");
            for (Integer id : books.keySet()) {
                System.out.println("ID: " + id + "  Title: " + books.get(id));
            }
            System.out.println("Library Classification: " + libraryClassification);
        }
        input.close();
    }
}
