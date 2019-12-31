import java.util.Date;
import java.io.*;
public class BorrowedBookLinkedList
{
    private BorrowedBookLinkedList bbl;
    BorrowedBookNode start;
    public Book book;
    public User user;
    BorrowedBookLinkedList()   //Empty constructor
    {
        start = null;
    }
      /*
     * Adds books to the LinkedLIst 'BorrowedBookLinkedList'
     */
    void insert(BorrowedBook bb)
    {
        BorrowedBookNode nptr = new BorrowedBookNode(bb,null);
        if(start == null)
        {
            start = nptr;
        }
        else
        {
            BorrowedBookNode tptr = start;
            while(tptr.link!=null)
            {
                tptr = tptr.link;
            }
            tptr.setLink(nptr);
        }
    }
      /*
     * Deletes books from the LinkedLIst 'BorrowedBookLinkedList'
     */
    void delete(String bookName) 
    {
        BorrowedBook bb = null;
        boolean flag = false;
        if(start == null)//checks if Linked list is empty
        {
            System.out.println("No Borrowed books present");
        }
        else
        {
            BorrowedBookNode tptr = start;
            bb = tptr.getData();
            if(tptr.link == null)//checks if there is only one node in linked list
            {
                if(bookName.equalsIgnoreCase(bb.getBook().getBookName())) 
                {
                    start = start.link;
                    System.out.println("Book returned succesfully");
                }
                else
                {
                    System.out.println("You do not have borrowed books");
                }
            }
            else//if multiple nodes present in linked list
            {
                BorrowedBookNode current = start;
                BorrowedBookNode prev = start;
                while(current.link !=null)
                {
                    bb = current.getData();
                    if(bookName.equalsIgnoreCase(bb.getBook().getBookName()))
                    {
                        if(current == start)
                        {
                            start = current.link;
                            System.out.println("Book returned succesfully");
                        }
                        else
                        {
                            prev.link = current.link;
                            System.out.println("Book returned succesfully");
                        }
                        flag = true;
                    }
                    else
                    {
                        if(current == start)
                        {
                            current = current.link;
                        }
                        else
                        {
                            prev = current;
                            current = current.link;
                        }
                    }
                }
                if(flag == false)//if last node is encountered
                {
                    bb = current.getData();
                    if(bookName.equalsIgnoreCase(bb.getBook().getBookName()))
                    {
                            prev.link = null;
                            System.out.println("Book returned succesfully");
                    }
                    else
                    {
                        System.out.println("");
                        System.out.println("Borrowed book not present");
                    }
                }
            }
        }
     }
           /*
     * Prints the all Borrowed Books from the Linked List
     */
     public void printAllBorowedBooks()
    {
        BorrowedBookNode tptr = start;
        BorrowedBook bb = null;
        if(tptr == null)//checks if Linked list is empty
        {
            System.out.println("");
            System.out.println("No books borrowed yet");
        }
        else
        {
            System.out.println("\t BOOK NAME \t\t\t\t\t\t AUTHOR \t\t ISBN \t\t BORROW DATE \t DUE DATE \t USERNAME \t USER ID");
            System.out.println("");
            if(tptr.link == null)//checks if there is only one node in linked list
            {
                   bb = tptr.getData();
                   if(bb != null)
                   {
                         bb.printBorrowedBook(); 
                   }
            }  
            else//if multiple nodes present in linked list
            {
                 while(tptr.link!= null)
                 {
                      bb = tptr.getData();
                      if(bb != null)
                      {
                           bb.printBorrowedBook(); 
                      }
                      tptr = tptr.link;
                 }
                 bb = tptr.getData();
                 if(bb != null)
                 {
                        bb.printBorrowedBook(); 
                 }
            }
        }
    }
     /*
     * Finds the index of the borrowed book using Book name
     */
     public BorrowedBook findBorrowedBook(String bookName,int num)
    {
        BorrowedBookNode tptr = start;
        BorrowedBook bb = null;
        if(tptr.link == null)//checks if there is only one node in linked list
        {
             bb = tptr.getData();
             if(bookName.equalsIgnoreCase(bb.getBook().getBookName()))
             {
                  if(num == bb.getUser().getUserID())
                  {
                      return bb;
                  }
                  else
                  {
                      System.out.println("You have not borrowed this Book");
                  }
             }
        }
        else//if multiple nodes present in linked list
        {
            while(tptr.link!= null)
            {
                bb = tptr.getData();
                if(bb != null)
                {
                      if(bookName.equalsIgnoreCase(bb.getBook().getBookName()))
                      {
                         if(num == bb.getUser().getUserID())
                         {
                             return bb;
                         }
                         else
                         {
                             System.out.println("You have not borrowed this Book");
                         }
                      }
                }
                tptr = tptr.link;
            }
            bb = tptr.getData();
            if(bookName.equalsIgnoreCase(bb.getBook().getBookName()))
            {
                if(num == bb.getUser().getUserID())
                {
                     return bb;
                }
                else
                {
                    System.out.println("You have not borrowed this Book");
                }
            }
        }
        System.out.println("You have not borrowed this Book");
        return null;
    } 
     /*
     * Stores the Borrowed Books in the array borrowedBooks[]
     */
    public void storeAllBorrowedBooks(PrintWriter pw) 
    {
        BorrowedBookNode tptr = start;
        if(tptr == null)//checks if Linked list is empty
        {
            //System.out.println("No borrowed books to store");
        }
        else
        {
            BorrowedBook bb = null;
            if(tptr.link == null)//checks if there is only one node in linked list
            {
                 bb = tptr.getData(); 
                 bb.storeBorrowedBook(pw); 
            }
            else
            {
                while(tptr.link!= null)//if multiple nodes present in linked list
                {
                    bb = tptr.getData();
                    if(bb != null)
                    {
                         bb.storeBorrowedBook(pw); 
                    }
                    tptr = tptr.link;
                }
                bb = tptr.getData();
                bb.storeBorrowedBook(pw); 
            }
        }
    }
}