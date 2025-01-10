import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortListDemo {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(50);
        list.add(40);

        Collections.sort(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10,"Ramesh",30,400000));
        employees.add(new Employee(20,"Santosh",29,350000));
        employees.add(new Employee(30,"Sanjay",30,450000));
        employees.add(new Employee(40,"Pramod",29,500000));

       // Collections.sort(employees, new MySort());
       // Collections.sort(employees, ((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())));
        Collections.sort(employees, ((o1, o2) -> o1.getName().compareTo(o2.getName())));

        System.out.println(employees);

        List<String> fruits = new ArrayList<String>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        List<String> sortedList = fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(sortedList);

        List<String> sortedList1 = fruits.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(sortedList1);

        List<String> sortedList3 = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList3);

        List<String> sortedList4 = fruits.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(sortedList4);

        List<Employee> sortedEmployeesList = employees.stream().sorted(((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))).collect(Collectors.toList());
        List<Employee> sortedEmployeesList1 = employees.stream().sorted(Comparator.comparingLong(Employee::getSalary)).collect(Collectors.toList());

        System.out.println(sortedEmployeesList1);
    }
}

class MySort implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
      //  return (int) (o1.getSalary() - o2.getSalary());
        return (int) (o2.getSalary() - o1.getSalary());
    }
}

class Employee{
    private int id;
    private String name;

    public Employee( int id,String name, int age, long salary) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    private int age;
    private long salary;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}


