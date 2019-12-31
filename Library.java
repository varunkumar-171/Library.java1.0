import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.SimpleDateFormat;
public class Library
{
   private UserLinkedList ull;
   private BookLinkedList bll;
   private BorrowedBookLinkedList bbl;
   private int userId = 1;
   private int isbn = 1;
   public Library() 
   {
     ull = new UserLinkedList(); //creates user object u1l
     bll = new BookLinkedList(); // creates book object b1l
     bbl = new BorrowedBookLinkedList();// creates borrowed book object bbl
   }
   /*
   * Returns the index at the index at the Particular Index
   */
   public int getUserID()
   {
        String choice1 = "";
        Scanner a = new Scanner(System.in);
        System.out.println("Enter userId");
        int choice = a.nextInt();
        int num = ull.findUser(choice);
        int choice2 = 0;
        while(num == -1)
        {
            do
            {
                System.out.println("Do you want to enter again(Enter yes or no)");
                choice1 = a.next();
            }
            while(!choice1.equalsIgnoreCase("yes") && !choice1.equalsIgnoreCase("no"));
                if(choice1.equalsIgnoreCase("Yes"))
                {
                   System.out.println(""); 
                   while(true)
                   {
                        try
                        {
                              System.out.println("Enter userId"); 
                              choice2 = a.nextInt();
                              break;
                        } catch(InputMismatchException ime)
                        {
                              System.out.println("Invalid number");
                              a.next();
                        }
                   }
                   num = ull.findUser(choice2); // Calls the findUser method in UserLinkedLsst
                   if(num == -1)
                   {
                       continue;
                   }
                   else
                   {
                       break;
                   }
                }
            else
            {
                return 10;
            }
        }
        return num;
   }
   /*
    * This Method reads the details of user from the file Userdata.txt. 
    */
    public void loadUsersFromFile()
    {
       int count = 0;
       try
       {
           Scanner a = new Scanner(new File("Userdata.txt"));
           a.useDelimiter("\n");
           while(a.hasNext()) {
              String n1 = a.next();
              
              if(n1 == null || n1.equals("") || n1.equals("\n") || n1.equals("\r")) //Checks if the line is empty or not to read tokens
              {
                   System.out.println("Empty Line");
                   break;
              }
              System.out.println("<" + n1 + "> " + n1.length());
              count++;
              Scanner c = new Scanner(n1);
              c.useDelimiter(":");//Reads the token until a semicolon is encountered
              String userName = c.next();
              String emailID = c.next();
              long phoneNumber = c.nextLong(); 
              int userID = c.nextInt();
              String address = c.next();
              User u1 = new User(userName,phoneNumber,userID,false);
              u1.setAddress(address);
              u1.setEmailID(emailID);
              //u1.printUser();
              ull.insert(u1);//reads data from the file creates a object and inserts into linked list
              c.close();
           }
           System.out.println("loaded "+ count + " users");
           userId = ++count;
           a.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }  
    }
   /*
    * This Method reads the details of book from the file Bookdata.txt. 
    */
    public void loadBooksFromFile()
    {
        int count = 0;
       try
       {
           Scanner a = new Scanner(new File("Bookdata.txt"));
           a.useDelimiter("\n");
           while(a.hasNext()) {
              String n1 = a.next();
              if(n1 == null || n1.equals("") || n1.equals("\n") || n1.equals("\r")) {
                   System.out.println("Empty Line");
                   break;
              }
                   
              System.out.println("<" + n1 + "> " + n1.length());
              count++;
               
              Scanner c = new Scanner(n1);
              c.useDelimiter(":");//Reads the token until a semicolon is encountered
              String bookName = c.next();
              String author = c.next();
              int isbn = c.nextInt();
              boolean avail = c.nextBoolean();
              
              Book b1 = new Book(bookName,author,isbn,avail,false);
              //b1.printBook();
              bll.insert(b1);//reads data from the file creates a object and inserts into linked list
              c.close();
           }
           System.out.println("loaded "+count + " books");
           isbn = ++count;
           a.close();
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
   /*
    * This Method reads the details of Borrrowedbook from the file BorrowedBookdata.txt. 
    */
    public void loadBorrowedBooksFromFile()
    {
        int count = 0;
        try
        {
           Scanner a = new Scanner(new File("BorrowedBookdata.txt"));
           a.useDelimiter("\n");
           while(a.hasNext()) 
           {
               String n1 = a.next();
               if(n1 == null || n1.equals("") || n1.equals("\n") || n1.equals("\r")) 
               {
                   System.out.println("Empty Line");
                   break;
              }    
              System.out.println("<" + n1 + "> " + n1.length());
              count++;
              Scanner c = new Scanner(n1);
              c.useDelimiter(":");//Reads the token until a semicolon is encountered
              String bookName = c.next();
              String author = c.next();
              int isbn = c.nextInt();
              String bd = c.next();
              String dd = c.next();
              Book b1 = new Book(bookName,author,isbn);
              b1.printBook();
              
              String userName = c.next();
              int userID = c.nextInt();
              User u1 = new User(userName,userID);
              //u1.printUser();
              BorrowedBook bb = new BorrowedBook(b1,u1,bd,dd,false);
              bbl.insert(bb);//reads data from the file creates a object and inserts into linked list
              bb.printBorrowedBook();
              c.close();
           }
           System.out.println("loaded "+ count + " Borrowed books");
           count++;
           a.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
   public static void main(String[] args)
   {
        try
        {
            /*
            * Creates the respective Files
              */
            FileWriter bfw = new FileWriter("Bookdata.txt", true);
            BufferedWriter bbw = new BufferedWriter(bfw);
            PrintWriter bw = new PrintWriter(bbw);
            
            FileWriter ufw = new FileWriter("Userdata.txt", true);
            BufferedWriter ubw = new BufferedWriter(ufw);
            PrintWriter uw = new PrintWriter(ubw);
            
            FileWriter bbfw = new FileWriter("BorrowedBookdata.txt",true);
            BufferedWriter bbbw = new BufferedWriter(bbfw);
            PrintWriter bpw = new PrintWriter(bbbw);
            
            int option = 0; 
            String name,address,emailId,bookName,author,publication;
            long phoneNum = 0;
            String word = "yes";
            Library l = new Library(); //creates library object
            l.loadBooksFromFile();
            l.loadUsersFromFile();
            l.loadBorrowedBooksFromFile();
            Scanner a = new Scanner(System.in);
            a.useDelimiter("\n");
            boolean quitFlag = false;
            while(word.equalsIgnoreCase("yes"))
            {
                   System.out.print('\u000C');
                                                                                               //Main menu display
                   System.out.println("\t\tWelcome to ABC Lending Library");
                   System.out.println(" **************************************************************");
                   System.out.println(" *\t\t=====================================          *");
                   System.out.println(" *\t\t\tCreate User(Enter 1)                   *");
                   System.out.println(" *\t\t\tCreate Book(Enter 2)                   *");
                   System.out.println(" *\t\t\tPrint Userlist(Enter 3)                *");
                   System.out.println(" *\t\t\tPrint Booklist(Enter 4)                *");
                   System.out.println(" *\t\t\tBorrow Book(Enter 5)                   *");
                   System.out.println(" *\t\t\tPrint Borrowed BookList(Enter 6)       *");
                   System.out.println(" *\t\t\tReturn Book(Enter 7)                   *");
                   System.out.println(" *\t\t\tExit Library(Enter 8)                  *");
                   System.out.println(" *\t\t====================================           *");
                   System.out.println(" ****************************************************************");            
                   while(true)
                   {
                          try
                          {
                              System.out.print("Choose your option: ");
                              option = a.nextInt(); 
                              System.out.println("");
                              break;
                          }
                          catch(InputMismatchException ime)
                          {
                              System.out.println("Enter a proper number");
                              a.next();
                          }
                   }
                   switch(option)
                   {
                       case 1:
                       System.out.println("Enter your name");
                       name = a.next(); 
                       boolean phoneFlag = true;
                       while(true)
                       {
                           try//checks whether phone number has 10 digits
                           {
                               System.out.println("Enter your phone number");
                               phoneNum = a.nextLong();
                               if(String.valueOf(phoneNum).length() != 10)
                               {
                                   while(String.valueOf(phoneNum).length() != 10)
                                   {
                                        System.out.println("The phone number you entered is invalid!");  
                                        System.out.println("Enter the phone number(Must be ten digits): ");
                                        phoneNum = a.nextLong();
                                   }
                                   phoneFlag = false;
                               }
                               else
                               {
                                   phoneFlag = false;
                                }
                           } catch(InputMismatchException ime)
                           {
                               System.out.println("Invalid number");
                               a.next();
                           }
                           if(phoneFlag == false)
                           {
                               break;
                           }
                       }
                       System.out.println("Enter your Address");//accepts user details
                       address = a.next();
                       System.out.println("Enter your email-id");
                       emailId = a.next();
                       User u1 = new User(name,phoneNum,l.userId,true);
                       u1.setAddress(address);
                       u1.setEmailID(emailId);
                       System.out.println("");
                       u1.printUser();
                       System.out.println("Hi! " + name + " your user Id is " + l.userId);
                       l.userId++;
                       l.ull.insert(u1);//inserts node to linked list
                       break;
                       
                       case 2:
                       System.out.println("Enter name of Book");//accepts book details
                       bookName = a.next();
                       System.out.println("Enter book's author");
                       author = a.next();
                       System.out.println("Enter book's publication");
                       publication = a.next();
                       Book b1 = new Book( bookName,author,l.isbn,true,true);
                       l.isbn++;
                       l.bll.insert(b1);
                       System.out.println("");                       
                       break;
                       
                       case 3:
                       //System.out.println("Printing all Users");
                       l.ull.printAllUsers();
                       break;
                       
                       case 4:
                       //System.out.println("Printing all Books");
                       l.bll.printAllBooksName();
                       break;
                         
                       case 5:
                       int num1 = l.getUserID(); // Gets the correct userId and then allows borrowing  
                       if(num1 != 10)
                       {         
                              User u = l.ull.getUser(num1); 
                              l.ull.printName1(num1);
                              System.out.println("");
                              System.out.println("       LIST OF AVAILABLE BOOKS");
                              System.out.println("-------------------------------------------");
                              l.bll.printAllBooks();//prints all books in linked list
                              System.out.println("-------------------------------------------");
                              System.out.println("Enter book's name");
                              String choice1 = a.next();
                              int num = l.bll.findBook1(choice1); //finds if users book is present in library
                              while(num == -1)
                              {
                                    do
                                    {
                                        System.out.println("Do you want to enter again(Enter yes or no)");
                                        choice1 = a.next();
                                    }
                                    while(!choice1.equalsIgnoreCase("yes") && !choice1.equalsIgnoreCase("no"));
                                    if(choice1.equalsIgnoreCase("Yes"))
                                    {
                                       System.out.println(""); 
                                       System.out.println("Enter book's name");
                                       choice1 = a.next();
                                       num = l.bll.findBook1(choice1); //finds if users book is present in library
                                       if(num == -1)
                                       {
                                               continue;
                                       }
                                       else
                                       {
                                           break;
                                       }
                                    }
                                    else
                                    {
                                        break;
                                    }
                              }
                              while(num != -1)
                              {                           
                                   Book b = l.bll.getBook(num);//returns book object
                                   String choice2 = "";
                                   if(b.getAvailability() == true) // Checks for the Book's Availability then allows to borrow the book
                                   { 
                                       do
                                       {
                                            System.out.println("Do you want to borrow the book(Enter yes or no)");
                                            choice2 = a.next();
                                       }
                                       while(!choice2.equalsIgnoreCase("yes") && !choice2.equalsIgnoreCase("no"));
                                       if(choice2.equalsIgnoreCase("yes"))
                                       {
                                           BorrowedBook bb = new BorrowedBook(b,u,true);                                  
                                           l.bbl.insert(bb);
                                           System.out.println("");
                                           System.out.println("Book borrowed Succesfully"); 
                                           l.bll.setAvailability(b,false);//for availability update
                                           break;     
                                       }
                                       else
                                       {
                                            System.out.println("");
                                            System.out.println("Book not Borrowed");
                                            break;
                                       }
                                   }
                                   else
                                   {
                                        System.out.println("");
                                        System.out.println("Book is not available at the moment");
                                        break;
                                   }
                              }      
                       }
                       break;
                       
                       case 6:
                       // System.out.println("Printing all Borrowed Books");
                       l.bbl.printAllBorowedBooks();
                       break; 
                       
                       case 7:
                       int num = l.getUserID();
                       System.out.println("Enter name of the Book you want to return");
                       String bName = a.next();
                       BorrowedBook bb  = l.bbl.findBorrowedBook(bName,num);//checks if book is borrowed by the particular user
                       String choice1 = "";
                       if(bb!=null)
                       {
                           System.out.println("Book found");
                           Date d = new Date();
                           String s = "";
                           SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                           formatter = new SimpleDateFormat("dd-MM-yyyy");
                           s = formatter.format(d);
                           if(s.equals(bb.getDueDate()))//checks todays date with duedDate
                           {
                               System.out.println("");
                               System.out.println("Your due date has been crossed");
                               System.out.println("Fine of R.s 20 will be charged ");
                           }
                           Book b = bb.getBook();
                           l.bbl.delete(bName);//deletes the node from borrowed book linked list
                           l.bll.setAvailability(b,true);
                       }
                       else
                       {
                           break;
                       }                       
                       break;
                       
                       case 8:
                       l.ull.storeAllUsers(uw);
                       l.bll.storeAllBooks(bw);
                       l.bbl.storeAllBorrowedBooks(bpw);
                       quitFlag = true;
                       break; 
                       
                       default:
                       System.out.println("Invalid choice");
                       break;
                   }
                   if(quitFlag)
                   {
                       break;
                   }
                   System.out.println("");
                   do
                   {
                       System.out.println("Do you want to continue(Enter yes or no)");
                       word = a.next();
                    }
                    while(!word.equalsIgnoreCase("yes") && !word.equalsIgnoreCase("no"));
            }
            if(option !=8)
            {
                l.bbl.storeAllBorrowedBooks(bpw);
                System.out.println("");  
                l.ull.storeAllUsers(uw);
                l.bll.storeAllBooks(bw);
                System.out.println("Thank you for using the Library System");
                System.exit(0);
            }
            else
            {
                System.out.println("");  
                l.ull.storeAllUsers(uw);
                l.bll.storeAllBooks(bw);
                System.out.println("Thank you for using the Library System");
                System.exit(0);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e);
            e.printStackTrace();
            return;
        }
    }
}