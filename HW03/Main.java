import Class01.SameName;

public class Main {
    public static void main(String[] args) {
        Employee Lead = new Employee("Arestovich Aleksei", "Lead", "arestovich@gmail.com",
                "097 123-4567", 48);
        SameName Name1 = new SameName();
        Class02.SameName Name2 = new Class02.SameName();
        Car car = new Car();
        car.start();
        System.out.println(Lead.getAge());
    }
}