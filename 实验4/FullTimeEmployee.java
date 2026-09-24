public class FullTimeEmployee extends Employee{
    public double monthlySalary;
    public double bonus;
    public int yearsOfService;
    public FullTimeEmployee(){}
    public FullTimeEmployee(String employeeId,String name,String department
            ,double monthlySalary,double bonus,int yearsOfService){
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
        this.yearsOfService = yearsOfService;
    }
    public double calculateSalary(){
        return this.monthlySalary + this.bonus + 500;
    }
    public void promote(){
        this.monthlySalary *= 1.2;
    }
    public void getEmployeeInfo(){
        System.out.println("name:" + this.name + "\nmonthlySalary:" + this.monthlySalary + "\nbonus:" + this.bonus
                + "\nyearsOfService:" + this.yearsOfService + "\nSalary:" + this.calculateSalary());
    }
}
