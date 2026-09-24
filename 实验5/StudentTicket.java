package t2;

public class StudentTicket extends MovieTicket{
    public double discountRate;
    public StudentTicket(double originalPrice,double discountRate){
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
    }
    public void calcPrice(){
        this.actualPrice = this.originalPrice * this.discountRate;
    }
    public void showTicketInfo(){
        this.calcPrice();
        System.out.println("【学生票】原始票价：" + this.originalPrice + "元，折后，需实付票价：" + this.actualPrice + "元");
    }
}
