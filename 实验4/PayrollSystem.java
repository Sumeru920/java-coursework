import java.util.ArrayList;
public class PayrollSystem {
    public ArrayList<Employee> employees = new ArrayList<>(100);
    public void addEmployee(Employee emp){
        employees.add(emp);
    }
    public void removeEmployee(String employeeId){
        for(Employee item : employees){
            if(item.employeeId.equals(employeeId))employees.remove(item);
        }
    }
    public double calculateTotalPayroll(){
        double sum = 0;
        for(Employee item:employees){
            sum +=item.calculateSalary();
        }
        return sum;
    }
    public void generatePayrollReport(){
        for(Employee item:employees){
            System.out.println(item.name+"           "+item.calculateSalary());
        }
    }
}
