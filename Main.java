class Book {
private int bookId;
private String title;
private String author;
private double price;

private static int totalBooks = 0;
public Book(int bookId, String title, String author, double price)
 {
this.bookId = bookId;
this.title = title;
this.author = author;
this.price = price;
totalBooks++;
}


public void displayInfo() {
System.out.println("Book ID: " + bookId);
System.out.println("Title: " + title);
System.out.println("Author: " + author);
System.out.println("Price: " + price);
System.out.println("-----------------------------------");
}

public boolean search(int searchId)
 {
return this.bookId == searchId;
}

public boolean search(String searchTitle)
 {
return this.title.equalsIgnoreCase(searchTitle);
}

public Book getCostlierBook(Book otherBook) {
return (this.price >= otherBook.price) ? this : otherBook;
}

public static int getTotalBooks() {
return totalBooks;
}
public String getTitle() {
return title;
}
}



public class Main {
public static void main(String[] args) {
Book b1 = new Book(101, "Java Programming", "JamesGosling", 45);

Book b2 = new Book(102, "C Programming", "thomas",55);

Book b3 = new Book(103, "python", "james",70);

System.out.println("Total books created: " + Book.getTotalBooks());

System.out.println("===================================\n");

System.out.println("--- All Books Info ---");
b1.displayInfo();
b2.displayInfo();
b3.displayInfo();

System.out.println("--- Search Testing ---");

System.out.println("Searching b2 for ID 102: " + b2.search(102));

System.out.println("Searching b2 for ID 999: " + b2.search(999));

System.out.println("Searching b1 for Title 'Java Programming': " + b1.search("Java Programming"));

System.out.println("===================================\n");

System.out.println("--- Price Comparison ---");

System.out.println("Comparing '" + b2.getTitle() + "' and '" + b3.getTitle() + "'...");

Book costlier = b2.getCostlierBook(b3);

System.out.println("\nWinner (Costlier Book Details):");
costlier.displayInfo();
}
}