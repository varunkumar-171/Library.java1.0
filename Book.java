import java.util.*;
import java.lang.Object;
import java.io.*;
public class Book
{
    private String bookName;
    private String author;
    private int isbn;
    private boolean availability;
    private boolean newBook;

      /*
     * Non-Parameterized constructor
     */
    public Book()
    {
    }
      /*
     * Parameterized constructor 1
     */
    public Book(String BookName,String Author,int ISBN)
    {
        bookName = BookName;
        author = Author;
        isbn = ISBN;
        this.availability = true;
        this.newBook = false;
    }
      /*
     * Parameterized constructor 2
     */
    public Book(String BookName,String Author,int ISBN,boolean availability, boolean newBook)
    {
        bookName = BookName;
        author = Author;
        isbn = ISBN;
        this.availability = availability;
        this.newBook = newBook;
    }
     /*
     * Getter and Setter methods
     */
    public void setAvailability(Boolean availability)
    {
        this.availability = availability;
    }
    public void setNewBook(Boolean newBook)
    {
        this.newBook = newBook;
    }
    public String getBookName()
    {
        return bookName;
    }
    public String getAuthor()
    {
        return author;
    }
    public int getISBN()
    {
        return isbn;
    }
    public boolean getAvailability()
    {
        return availability;
    }
    public boolean getNewBook()
    {
        return newBook;
    }
      /*
     * Prints the details of the book
     */
    public void printBook()
    { 
                System.out.println("Book Name : " + bookName); 
                System.out.println("Author : " + author); 
                System.out.println("ISBN : " + isbn); 
                System.out.println("availability : " + availability);
                System.out.println("--------------------------------");
    }
     /*
     * Prints the name of the Book and author
     */
    public void printBookName()
    {
         System.out.println("Book Name : " + bookName); 
         System.out.println("Author : " + author);
         System.out.println("");
    }
    /*
     * This Method writes the details of book to the file Bookdata.txt. 
     */
    public void storeBook(PrintWriter pw) {
        try
        {
                if(newBook == true)
                {
                    pw.print(bookName+":"); 
                    pw.print(author+":"); 
                    pw.print(isbn+":"); 
                    pw.print(availability+":");    
                    pw.println("");
                    pw.flush(); // Flushes the stream.
                    pw.close();
                }
                else
                {
                    System.out.println("This book is already loaded");
                }
           }
           catch(Exception e)
           {
               System.out.println("Exception: " + e);
               return;
           }
    }
      /*
     * Test Harness 
     */
    public static void main(String[]args)
    {
           try
           {   
                BookLinkedList bll = new BookLinkedList();
                Book book1 = new Book("Alex Rider","Anthony Horowitz",454622);
                Book book2 = new Book("Percy Jackson","Rick Riordan",250022);
                Book book3 = new Book("Book3","Author3",454562);
                bll.insert(book1);
                bll.insert(book2);
                bll.insert(book3);
                bll.display();
          }
          catch(Exception e)
          {
                System.out.println("Exception: " + e);
                return;
          }
    }
}