public class UserNode
{
    User u;
    UserNode link;
    int userId;
     /*
     * Parameterized constructor 1
     */
    UserNode(User u,UserNode link)
    {
        this.u = u;
        this.link = link;
        userId = u.getUserID();
    }
     /*
     * getter setter methods
     */
    UserNode getLink()
    {
        return link;
    }
    User getData()
    {    
        return u;
    }
    int getUserId()
    {
        return userId;
    }
    void setLink(UserNode link)
    {
        this.link = link;
    }
    void setData(User u)
    {
        this.u = u;
        userId = u.getUserID();
    }
     /*
     * prints details of the Node
     */
    void printUserNode()
    {
        System.out.println("Printing User node-----------------");
        u.printUser();
        if(link != null)
        {
            //link.printUserNode();
            System.out.println("Link is not null");
        }   
        else
        {System.out.println("Link is null");}
        System.out.println("User ID: " + userId);
    }
}