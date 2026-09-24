public class PartTimeEmployee extends Employee{
    public double hourlyRate;
    public double hoursWorked;
    public int maxHoursPerWeek = 20;
    public PartTimeEmployee(){};
    public PartTimeEmployee(String employeeId,String name,String department
            ,double hourlyRate,double hoursWorked,int maxHoursPerWeek){
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.maxHoursPerWeek = maxHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
         if(this.hoursWorked > this.maxHoursPerWeek)
         {
             return (this.hoursWorked-maxHoursPerWeek)*1.5*hourlyRate + maxHoursPerWeek*hourlyRate;
         }
         return hoursWorked*hourlyRate;
    }
    public void requestMoreHours(int additionalHours){
        this.hoursWorked += additionalHours;
    }
    public void getEmployeeInfo(){
        System.out.println("name:" + this.name + "\nhourlyRate:" + this.hourlyRate + "\nhoursWorked:" + this.hoursWorked
                + "\nmaxHoursPerWeek:" + this.maxHoursPerWeek + "\nSalary:" + this.calculateSalary());
    }
}
