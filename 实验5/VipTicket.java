package t2;

public class VipTicket extends MovieTicket{
    public VipTicket(double originalPrice){
        this.originalPrice = originalPrice;
    }
    public void calcPrice(){
        this.actualPrice = this.originalPrice * 0.5;
    }
    public void showTicketInfo(){
        this.calcPrice();
        System.out.println("【VIP票】原始票价：" + this.originalPrice + "元，半折后，需实付票价：" + this.actualPrice + "元");
    }
}
