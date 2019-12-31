public class BorrowedBookNode
{
    BorrowedBook bb;
    BorrowedBookNode link;
         /*
     * Parameterized constructor 1
     */
    BorrowedBookNode(BorrowedBook bb,BorrowedBookNode link)
    {
        this.bb = bb;
        this.link = link;
    }
         /*
     * getter setter methods
     */
    BorrowedBookNode getLink()
    {
        return link;
    }
    BorrowedBook getData()
    {    
        return bb;
    }
    void setLink(BorrowedBookNode link)
    {
        this.link = link;
    }
    void setData(BorrowedBook bb)
    {
        this.bb = bb;
    }
}