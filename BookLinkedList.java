import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class BookLinkedList
{
    BookNode start;
    BookLinkedList()
    {
        start = null;
    }
    /*
     * INserts book nodes to Linked List
     */
    void insert(Book b)
    {
        BookNode nptr = new BookNode(b,null);
        if(start == null)
        {
            start = nptr;
        }
        else
        {
            BookNode tptr = start;
            while(tptr.link!=null)
            {
                tptr = tptr.link;
            }
            tptr.setLink(nptr);
        }
    }
     /*
     *  Displays detail of particular book
     */
    void display()
    {
        BookNode tptr = start;
        while(tptr.link!=null)
        {
            tptr.printBookNode();
            tptr = tptr.link;
        }
        tptr.printBookNode();
    }
      /*
     * Finds the index of the book using Book name
     */
    public int findBook1(String bookName)
    {
        BookNode tptr = start;
        Book b = null;
        int i = 0;
        if(tptr == null)
        {
            System.out.println("No books in library yet");
        }
        else
        {
                if(tptr.link == null)
                {
                    if(bookName.equalsIgnoreCase(b.getBookName()))
                    {
                         System.out.println("");
                         System.out.println("Book Found");
                         return i;
                    }
                }
                else
                {
                    while(tptr.link!= null)
                    {
                        b = tptr.getData();
                        if(b != null)
                        {
                              if(bookName.equalsIgnoreCase(b.getBookName()))
                              {
                                  System.out.println("");
                                  System.out.println("Book Found");
                                  return i;
                              }
                        }
                        i++;
                        tptr = tptr.link;
                    }
                    b = tptr.getData();
                    if(bookName.equalsIgnoreCase(b.getBookName()))
                    {
                         System.out.println("");
                         System.out.println("Book Found");
                         return i;
                    }
                }
        } 
        System.out.println("Book not found");
        return -1;
    }
        /*
     * Prints the name of Book and author
     */
    public void printAllBooksName()
    {
       BookNode tptr = start;
       Book b = null;
       if(tptr.link == null)//checks if only one node is present
       {
           if(b != null)
           {
                b = tptr.getData();
                b.printBookName();
           }
           else
           {
               System.out.println("");
               System.out.println("No books present in Library");
            }
       }
       else//if multiple nodes are present
       {
           while(tptr.link!= null)
            {
                b = tptr.getData();
                if(b != null)
                {
                     b.printBookName(); 
                }
                tptr = tptr.link;
            }
           b = tptr.getData();
           b.printBookName();
       }
    }
      /*
     * Stores the books in the File
     */
    public void storeAllBooks(PrintWriter pw) 
    {
        BookNode tptr = start;
        if(start == null)
        {
            //System.out.println("No books to store");
        }
        else
        {
            Book b = null;
            if(tptr.link == null)//checks if only one node is present
            {
                b = tptr.getData();
                if(b.getNewBook())
                {   
                   b.storeBook(pw); 
                }
            }
            else//if multiple nodes are present
            {
                while(tptr.link!= null)
                {
                    b = tptr.getData();
                    if(b != null)
                    {
                         if(b.getNewBook())
                         {   
                             b.storeBook(pw); 
                         }
                    }
                    tptr = tptr.link;
                }
                b = tptr.getData();
                if(b.getNewBook())//stores last node
                {   
                   b.storeBook(pw); 
                } 
            }
        }
    }
    /*
     * prints all the books in the Linked List
     */
    public void printAllBooks()
    {
        BookNode tptr = start;
        Book b = null;
        if(tptr.link == null)
        {
           if(b != null)
           {
                b = tptr.getData();
                b.printBook();
           }
           else
           {
               System.out.println("");
               System.out.println("No books present in Library");
            }
        }
        else
        {
            while(tptr.link!= null)
            {
                b = tptr.getData();
                 if(b != null)
                {
                     b.printBook(); 
                }
                tptr = tptr.link;
            }
            b = tptr.getData();
            b.printBook();
        }
    }
    /*
     * Returns the book at the particular index
     */
    public Book getBook(int num)
    {
        BookNode tptr = start;
        for(int i = 0;i<num;i++)
        {
            tptr = tptr.link;
        }
        Book b = tptr.getData();
        return b;
    }
    /*
     * Sets the availability to true or false, before or after borrowing the book respectively
     */   
    public void setAvailability(Book  b,boolean availability)
    {  
      b.setAvailability(availability);
    }
    /*
     * Test Harness
     */   
    public static void main(String[] args)
    {
            BookLinkedList bll = new BookLinkedList();
            Book book1 = new Book("Alex Rider","Anthony Horowitz",454622);
            Book book2 = new Book("Percy Jackson","Rick Riordan",250022);
            Book book3 = new Book("Book3","Author3",454562);
            bll.insert(book1);
            bll.insert(book2);
            bll.insert(book3);
            bll.display();
            try{
                FileWriter bbfw = new FileWriter("BookData.txt", true);
                BufferedWriter bbbw = new BufferedWriter(bbfw);
                PrintWriter bpw = new PrintWriter(bbbw);
                bpw.print("Varun");
                bll.storeAllBooks(bpw);
            }
            catch(Exception e)
            {
            }
    }
}