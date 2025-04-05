import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    String id;
    boolean isAvailable;
    Book next, prev;

    Book(String title, String author, String genre, String id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head = null, tail = null;

    void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at beginning.");
    }

    void addAtEnd(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at end.");
    }

    void addAtPosition(int position, Book newBook) {
        if (position <= 1 || head == null) {
            addAtBeginning(newBook);
            return;
        }

        Book temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
            System.out.println("Book added at position " + position);
        }
    }

    void removeBookByID(String id) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;

        if (head.id.equals(id)) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            System.out.println("Book removed.");
            return;
        }

        while (temp != null && !temp.id.equals(id)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed.");
    }

    void searchBook(String query) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found.");
    }

    void updateAvailability(String id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.id.equals(id)) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        System.out.println("\n--- Books in Forward Order ---");
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        System.out.println("\n--- Books in Reverse Order ---");
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    void displayBook(Book b) {
        System.out.println("----------------------------");
        System.out.println("Title      : " + b.title);
        System.out.println("Author     : " + b.author);
        System.out.println("Genre      : " + b.genre);
        System.out.println("Book ID    : " + b.id);
        System.out.println("Available? : " + (b.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title/Author");
            System.out.println("6. Update Availability Status");
            System.out.println("7. Display Books (Forward)");
            System.out.println("8. Display Books (Reverse)");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            String title, author, genre, id;
            boolean available;
            int position;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Book Title: "); title = sc.nextLine();
                    System.out.print("Enter Author: "); author = sc.nextLine();
                    System.out.print("Enter Genre: "); genre = sc.nextLine();
                    System.out.print("Enter Book ID: "); id = sc.nextLine();
                    System.out.print("Is Available (true/false): "); available = sc.nextBoolean(); sc.nextLine();
                    Book newBook = new Book(title, author, genre, id, available);

                    if (choice == 1)
                        library.addAtBeginning(newBook);
                    else if (choice == 2)
                        library.addAtEnd(newBook);
                    else {
                        System.out.print("Enter Position: ");
                        position = sc.nextInt(); sc.nextLine();
                        library.addAtPosition(position, newBook);
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextLine();
                    library.removeBookByID(id);
                    break;

                case 5:
                    System.out.print("Enter Book Title or Author to search: ");
                    String query = sc.nextLine();
                    library.searchBook(query);
                    break;

                case 6:
                    System.out.print("Enter Book ID to update: ");
                    id = sc.nextLine();
                    System.out.print("New Availability (true/false): ");
                    available = sc.nextBoolean(); sc.nextLine();
                    library.updateAvailability(id, available);
                    break;

                case 7:
                    library.displayForward();
                    break;

                case 8:
                    library.displayReverse();
                    break;

                case 9:
                    library.countBooks();
                    break;

                case 10:
                    System.out.println("Exiting Library System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        sc.close();
    }
}
