import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class BorrowedBook
{
    private Book book;
    private User user;
    private BorrowedBook borrowedbook;
    private boolean newBorrowedBook;
    private String dueDate ;
    private String borrowDate;
     /*
     * Parameterized constructor 1
     */
    public BorrowedBook(Book book,User user,boolean newBorrowedBook)
    {
       this.book = book;
       this.user = user;
       borrowDate = getBorrowDate();
       dueDate = getDueDate();
       this.newBorrowedBook = newBorrowedBook;
    }  
    public BorrowedBook(Book book,User user,String borrowDate,String dueDate,boolean newBorrowedBook)
    {
       this.book = book;
       this.user = user;
       this.newBorrowedBook = newBorrowedBook;
       this.borrowDate = borrowDate;
       this.dueDate = dueDate;
    }
     /*
     * getter methods
     */
    Book getBook()
    {
        return book;
    }
    User getUser()
    {
        return user;
    }
    BorrowedBook getBorrowedBook()
    {
        return borrowedbook;
    }
    public boolean getNewBorrowedBook()
    {
        return newBorrowedBook;
    }
      /*
     * Date functions
     */
    public static Date addDays(Date date, int days)//function to add particular no of days from current date
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); 
        return cal.getTime();
    }
    public String getDueDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        String s = "";
        Date dueDate = addDays(d,7);
        try 
        {
           formatter = new SimpleDateFormat("dd-MM-yyyy");
           s = formatter.format(dueDate);
        }
        catch(Exception e)
        {
        }
        return s;
    }
    public Date getReturnDate()
    {
        Date d = new Date();
        return d;
    }
    public String getBorrowDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        String s = "";
        try 
        {
           formatter = new SimpleDateFormat("dd-MM-yyyy");
           s = formatter.format(d);
        }
        catch(Exception e)
        {
        }
        return s;
    }
     /*
     * Prints details of the borrowed book
     */
    public void printBorrowedBook()
    {
        int biglength1 = 43;
        if(book.getBookName().length()==43)
        {
            System.out.print(" * " + book.getBookName());
            System.out.print("\t\t\t");
        }
        else
        {
            System.out.print(" * " + book.getBookName());
            for(int i = 0;i<=(biglength1-book.getBookName().length());i++)
            {
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\t\t\t");
        }
        int biglength2 = 19;
        if(book.getAuthor().length() == 19)
        {
            System.out.print(book.getAuthor());
            System.out.print("\t");
        }
        else
        {
            System.out.print(book.getAuthor());
            for(int i = 0;i<=(biglength2-book.getAuthor().length());i++)
            {
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\t");
        }
        System.out.println(book.getISBN() + "\t\t" +  borrowDate + "\t" + dueDate + "\t" + user.getUserName() + "\t\t" + user.getUserID());                       
    }
     /*
     * Stores borrowed book to the file
     */
    public void storeBorrowedBook(PrintWriter pw) 
    {
          try
          {
              if(newBorrowedBook == true)
              {
                  pw.print(book.getBookName()+":");
                  pw.print(book.getAuthor()+":"); 
                  pw.print(book.getISBN()+":"); 
                  pw.print(borrowDate+":");
                  pw.print(dueDate+":");
                       
                  pw.print(user.getUserName()+":"); 
                  pw.print(user.getUserID()+":");
                           
                  pw.println("");
                  pw.flush();
                  pw.close();
              }
          }               
          catch(Exception e)
          {
                  System.out.println("Exception: " + e);
                  return;
          }
    }
}