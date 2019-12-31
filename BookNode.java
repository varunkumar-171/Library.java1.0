public class BookNode
{
    Book b;
    BookNode link;
    String bookName;
         /*
     * Parameterized constructor 1
     */
    BookNode(Book b,BookNode link)
    {
        this.b = b;
        this.link = link;
        bookName = b.getBookName();
    }
         /*
     * Getter setter methods
     */
    BookNode getLink()
    {
        return link;
    }
    Book getData()
    {    
        return b;
    }
    String getBookName()
    {
        return bookName;
    }
    void setLink(BookNode link)
    {
        this.link = link;
    }
    void setData(Book b)
    {
        this.b = b; 
        bookName = b.getBookName();
    }
         /*
     * Prints the details of the node
     */
    void printBookNode()
    {
        System.out.println("Printing Book node-----------------");
        b.printBook();
        if(link != null)
        {
            //link.printUserNode();
            System.out.println("Link is not null");
        }   
        else
        {System.out.println("Link is null");}
        System.out.println("Book Name: " + bookName);
    }
}