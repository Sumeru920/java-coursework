package t2;

public class ChildTicket extends MovieTicket{
    public double freeTicketPrice;
    public double discountAmount;
    public ChildTicket(double originalPrice,double freeTicketPrice,double discountAmount){
        this.originalPrice = originalPrice;
        this.freeTicketPrice = freeTicketPrice;
        this.discountAmount = discountAmount;
    }
    public void calcPrice(){
        if(this.originalPrice <= this.freeTicketPrice){
            this.actualPrice = 0;
        }else {
            this.actualPrice = this.originalPrice - this.discountAmount;
        }
    }
    public void showTicketInfo(){
        this.calcPrice();
        System.out.println("【儿童票】原始票价：" + this.originalPrice + "元，优惠后，需实付票价：" + this.actualPrice + "元");
    }
}
