package t2;

public class MovieTicket {
    public double originalPrice;
    public double actualPrice;
    public String ticketType;
    public MovieTicket(){}
    public MovieTicket(double originalPrice){
        this.originalPrice = originalPrice;
    }
    public void calcPrice(){
        this.actualPrice = this.originalPrice;
    }
    public void showTicketInfo(){
        if(this instanceof StudentTicket){
            ((StudentTicket)this).showTicketInfo();
        }else if(this instanceof VipTicket){
            ((VipTicket)this).showTicketInfo();
        }else if(this instanceof ChildTicket){
            ((ChildTicket)this).showTicketInfo();
        }else{
            this.calcPrice();
            System.out.println("【电影票】原始票价：" + this.originalPrice + "元");
        }
    }
    public static void main(String[] args) {
        System.out.println("原始票价为50元");
        MovieTicket childTicket1 = new ChildTicket(50,30,15);
        childTicket1.showTicketInfo();
        MovieTicket studentTicket1 = new StudentTicket(50,0.8);
        studentTicket1.showTicketInfo();
        MovieTicket vipTicket1 = new VipTicket(50);
        vipTicket1.showTicketInfo();

        System.out.println("原始票价为30元");
        MovieTicket childTicket2 = new ChildTicket(30,30,15);
        childTicket2.showTicketInfo();
        MovieTicket studentTicket2 = new StudentTicket(30,0.8);
        studentTicket2.showTicketInfo();
        MovieTicket vipTicket2 = new VipTicket(30);
        vipTicket2.showTicketInfo();
    }
}
