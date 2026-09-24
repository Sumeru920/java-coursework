public class LibraryItem {
    public String itemId;
    public String title;
    public String author;
    boolean isBorrowed = false;
    public LibraryItem(){};
    public LibraryItem(String itemId,String title,String author){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public void borrow(){
        this.isBorrowed = true;
    }
    public void returnItem(){
        this.isBorrowed = false;
    }
    public void getInfo(){
        System.out.println("Id:" + this.itemId + "\ntitle:" + title
                + "\nauthor:" + this.author + "\nisBorrowed:" + this.isBorrowed);
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
    public static void main(){
        Book b1 = new Book("B001","Java编程思想","Bruce Eckel"
                ,"987-7-111-21382-6",880,"计算机科学");
        b1.borrow();
        b1.getInfo();
        b1.renew();
        b1.getInfo();
        b1.returnItem();
        b1.getInfo();

        Magazine m1 = new Magazine("M001","国家地理","国家地理学会",202,"2023-10",true);
        m1.borrow();
        m1.getInfo();
        m1.reserve();
        m1.getInfo();
        m1.returnItem();
        m1.getInfo();
        LibraryItem[] l = new LibraryItem[4];
        l[0] = new Book();
        l[1] = new Book();
        l[2] = new Magazine();
        l[3] = new Magazine();
        for(int i = 0; i < 4; i++){
            l[i].getInfo();
        }
    }
}
