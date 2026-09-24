public class Magazine extends LibraryItem{
    public int issueNumber;
    public String publicationDate;
    public boolean isCurrentIssue;
    public int BorrowDate;
    public Magazine(){}
    public Magazine(String itemId,String title,String author,
                    int issueNumber, String publicationDate,boolean isCurrentIssue){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.isCurrentIssue = isCurrentIssue;
    }
    public void borrow(){
        this.isBorrowed = true;
        this.BorrowDate = 7;
    }
    public void reserve(){
        if(this.isCurrentIssue&&!this.isBorrowed){
            this.isBorrowed = true;
            BorrowDate = 7;
        }else if(this.isCurrentIssue&&isBorrowed){
            System.out.println("Fail to reserve");
        }
    }
    public void getInfo(){
        System.out.println("issueNumber:" + this.issueNumber + "\npublicationDate:" + publicationDate
                + "\nisCurrentIssue:" + this.isCurrentIssue );
        if(isBorrowed){
            System.out.println("isBorrowed:" + this.isBorrowed + "\nBorrowDate:" + this.BorrowDate);
        }
    }
}
