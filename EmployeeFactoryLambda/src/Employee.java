public class Employee {
    private String name;
    public Employee() {
        System.out.println("Empty Constructor");
    }
    public Employee(String name) {
        System.out.println("Constructor with name");
        this.name = name;
    }
    @Override public String toString() {
        return "Name:" + name;
    }
    public static void main(String[] args) {
        EmployeeFactory ef = Employee::new;
        System.out.println("Constructor not called yet.");
        Employee x = ef.get();
        System.out.println(x);
        EmployeeFactoryName efn = Employee::new;
        System.out.println("New constructor about to be called");
        Employee y = efn.get("Bob");
        System.out.println(y);
    }
}
