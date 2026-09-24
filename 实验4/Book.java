public class Book extends LibraryItem{
    public String ISBN;
    public int pageCount;
    public String genre;
    public int BorrowDate;
    public Book(){};
    public Book(String itemId,String title,String author,String ISBN,int pageCount,String genre){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.genre = genre;
    }
    public void borrow(){
        this.isBorrowed = true;
        this.BorrowDate = 30;
    }
    public void renew(){
        this.BorrowDate += 15;
    }
    public void getInfo(){
        System.out.println("ISBN:" + this.ISBN + "\npageCount:" + this.pageCount
                + "\ngenre:" + this.genre);
        if(this.isBorrowed){
            System.out.println("isBorrowed:" + this.isBorrowed + "\nBorrowDate:" + this.BorrowDate);
        }
    }
}
