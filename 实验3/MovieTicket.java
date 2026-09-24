import java.util.Scanner;
public class MovieTicket {
    private String movieName;
    private double price;
    static int count = 0;
    public MovieTicket(){
        count++;
    }
    public MovieTicket(String name){
        this.movieName = name;
        count++;
    }
    public MovieTicket(String name,double price){
        this.movieName = name;
        this.price = price;
        count++;
    }
    public double getFinalPrice(){
        return this.price;
    }
    public double getFinalPrice(double discount){
        return this.price * discount;
    }
    public double getFinalPrice(double discount, double concession){
        return (this.price - concession) * discount;
    }
    public static void createTickets(){
        double sum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the movie name and its price:");
        String continueInput = "yes";
        while(continueInput.equalsIgnoreCase("yes")){
            MovieTicket m = new MovieTicket();
            m.movieName = input.nextLine();
            m.price = input.nextDouble();
            input.nextLine();//消耗换行符
            sum += m.calculatePrice();

            System.out.println("Add another ticket?(yes/no)");
            continueInput = input.nextLine();
        }
        System.out.println("total cost:" + sum);
        System.out.println("total number of tickets:" + count);
    }
    public double calculatePrice(){
        Scanner input = new Scanner(System.in);
        System.out.println(this.movieName + ":");
        System.out.println("Enter 1 for discount\n2 for concession\n3 for both\n4 for none");
        int num = input.nextInt();
        double discount = 1;
        double concession = 0;

            switch(num){
                case 1:
                    System.out.println("discount:");
                    discount = input.nextDouble();
                    break;
                case 2:
                    System.out.println("concession：");
                    concession = input.nextDouble();
                    break;
                case 3:
                    System.out.println("discount:");
                    discount = input.nextDouble();
                    System.out.println("concession:");
                    concession = input.nextDouble();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input,no discount applied.");
            }
            return getFinalPrice(discount,concession);


    }
    public static void main(String []args) {
        createTickets();
    }
}
