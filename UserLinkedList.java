import java.io.*;
import java.util.*;
public class UserLinkedList
{
    UserNode start;
    int noOfUsers = 0;
    UserLinkedList()
    {
        start = null;
    }
     /*
     * Inserts user nodes to the Linked List 'userLinkedList'
     */
    void insert(User u)
    {
        UserNode nptr = new UserNode(u,null);
        if(start == null)
        {
            start = nptr;
        }
        else
        {
            UserNode tptr = start;
            while(tptr.link!=null)
            {
                tptr = tptr.link;
            }
            tptr.setLink(nptr);
        }
    }
     /*
     * Displays details of the particular node
     */
    void display()
    {
        UserNode tptr = start;
        while(tptr.link!=null)
        {
            tptr.printUserNode();
            tptr = tptr.link;
        }
        tptr.printUserNode();
    }
     /*
     * Finds a user with his user id
     */
    int findUser(int userId)
    {
        UserNode tptr = start;
        User u = getUser(userId);
        if(tptr == null)
        {
            System.out.println("No users registered yet");
        }
        else
        {
            if(tptr.link == null)
            {
                if(userId == tptr.getUserId())  
                {
                     System.out.println("User found");
                     return userId;
                }
            }
            else 
            {
                while(tptr.link!= null)
                 {
                    u = tptr.getData();
                     if(u != null)
                     {
                         if(userId == tptr.getUserId())  
                         {
                             System.out.println("User found");
                             return userId;
                         }
                    }
                    tptr = tptr.link;
                }
                u = tptr.getData();
                if(userId == u.getUserID())  
                {
                     System.out.println("User found");
                     return userId;
                }
            }
            System.out.println("User not found");
        }
        System.out.println("");
        return -1;
    }
     /*
     * Prints the name of the user
     */
      public void printName1(int num)
    {
        UserNode tptr = start;
        if(num == 1)
        {
            User u = tptr.getData();
            u.printName(num);
        }
        else
        {
            for(int i = 1;i<num;i++)
            {
                tptr = tptr.link;
            }
            User u = tptr.getData();
            u.printName(num);
        }
    }
     /*
     *  Gets  the user at the particular index
     */
    public User getUser(int num)
    {
            if(num > noOfNodes())
            {
                System.out.println("Invalid userId");
            }
            else
            {
                User u = null;
                UserNode tptr = start;
                if(num == 1)
                {
                    return start.getData();
                }
                else if(num > noOfNodes())
                {
                    System.out.println("Invalid userId");
                }
                else
                {
                    for(int i = 1;i<num;i++)
                    {
                        tptr = tptr.link;
                    }
                    u = tptr.getData();
                }
                return u; 
            }
            return null;
    }
     /*
     * Prints all the users from the LinkedList
     */
    public void printAllUsers()
    {
        UserNode tptr = start;
        User u = null;
        if(tptr == null)
        {
            System.out.println("No users registered yet");
        }
        else
        {
            if(tptr.link == null)
            {
                     u = tptr.getData();
                     u.printUser(); 
            }
            else
            {
                while(tptr.link!= null)
                {
                    u = tptr.getData();
                    if(u != null)
                    {
                         u.printUser(); 
                    }
                    tptr = tptr.link;
                }
                u = tptr.getData();
                u.printUser(); 
            }
        }
    }
     /*
     * Stores the Nodes to the files
     */
    public void storeAllUsers(PrintWriter pw) 
    {
        UserNode tptr = start;
        if(start == null)
        {
            //System.out.println("No users to store");
        }
        else
        {
            User u = null;
            if(tptr.link == null)
            {
                u = tptr.getData();
                if(u.getNewUser())
                {
                     u.storeUser(pw); 
                }
            }
            else
            {
                while(tptr.link!= null)
                {
                    u = tptr.getData();
                    if(u != null)
                    {
                          if(u.getNewUser())
                          {   
                              u.storeUser(pw); 
                          } 
                    }
                    tptr = tptr.link;
                }
                u = tptr.getData();
                if(u.getNewUser())
                {   
                       u.storeUser(pw); 
                } 
            }
        }
    }
    int noOfNodes()
    {
        UserNode tptr = start;
        int N = 0;
        if(tptr == null)
        {
            return N;
        }
        else
        {
            while(tptr.link!=null)
            {
                N++;
                tptr = tptr.link;
            }
            N++;
        }
        return N;
    }
     /*
     * Test harness
     */
    public static void main()
    {
        UserLinkedList ull = new UserLinkedList();
        User u1  = new  User("Varun Kumar",8778918293L,1);
        ull.insert(u1);
        User u2  = new  User("Abhishek Kumar",9444545078L,2);
        ull.insert(u2);
        ull.display();
        try
        {
            FileWriter ufw = new FileWriter("Userdata.txt", true);
            BufferedWriter ubw = new BufferedWriter(ufw);
            PrintWriter uw = new PrintWriter(ubw);
            ull.storeAllUsers(uw); 
        }
        
        catch(Exception e)
        {
        }
    }  
}