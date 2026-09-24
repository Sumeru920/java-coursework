public class Employee {
    public String employeeId;
    public String name;
    public String department;
    public Employee(){}
    public Employee(String employeeId,String name,String department){
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }
    public double calculateSalary(){
        return 0.0;
    }
    public void getEmployeeInfo(){
        System.out.println("employeeId:" + this.employeeId + "\nname:" + this.name
                + "\ndepartment:" + this.department);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void main(String []args){
        FullTimeEmployee f1 = new FullTimeEmployee("FT001","张三","技术部",8000,2000,3);
        f1.calculateSalary();
        f1.getEmployeeInfo();
        f1.promote();
        f1.calculateSalary();
        f1.getEmployeeInfo();

        PartTimeEmployee p1 = new PartTimeEmployee("PT001","李四","市场部",50,25,20);
        p1.calculateSalary();
        p1.getEmployeeInfo();
        p1.requestMoreHours(10);
        p1.calculateSalary();
        p1.getEmployeeInfo();

        PayrollSystem ps1 = new PayrollSystem();
        ps1.addEmployee(f1);
        ps1.addEmployee(p1);
        ps1.calculateTotalPayroll();
        ps1.generatePayrollReport();
    }
}
