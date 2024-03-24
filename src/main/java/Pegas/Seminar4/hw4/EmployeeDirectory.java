package Pegas.Seminar4.hw4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private final List<Employee> list;

    public EmployeeDirectory() {
        this.list = new ArrayList<>();
    }
    public void add(Employee employee){
        list.add(employee);
    }
    public List<Employee> findByExperience(int years){
        List<Employee> arr = new ArrayList<>();
        for (Employee i: list){
            if(i.getExperience()==years){
                arr.add(i);
            }
        }
        return arr;
    }
    public List<String> findPhoneByName(String name){
        List<String> arr = new ArrayList<>();
        for (Employee i: list){
            if(i.getName().equals(name)){
                arr.add(i.getPhoneNumber());
            }
        }
        return arr;
    }
    public List<Employee> findByEmployeeId(int id){
        List<Employee> arr = new ArrayList<>();
        for (Employee i: list){
            if(i.getEmployeeId()==(id)){
                arr.add(i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.add(new Employee(1, "79526321545", "Igor", 5));
        employeeDirectory.add(new Employee(2, "79526324562", "Lira", 2));
        employeeDirectory.add(new Employee(20, "79526328542", "Lira", 14));
        employeeDirectory.add(new Employee(4, "79526322255", "Kira", 5));
        System.out.println(employeeDirectory.list);
        System.out.println(employeeDirectory.findByExperience(5));
        System.out.println(employeeDirectory.findPhoneByName("Lira"));
        System.out.println(employeeDirectory.findByEmployeeId(1));
    }
}
