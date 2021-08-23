package codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "not null")
    private String name;

    @Pattern(regexp = "^[a-z]{3,}[A-Z]{1,}$", message = "thuong 3 hoa 1")
    private String code;

    @Min(value = 18,message = " > 18")
    private int age;

    @Min(value = 0, message = "not am")
    private double salary;

    @ManyToOne
    private Branch branch;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Employee(String name, String code, int age, double salary, Branch branch) {
        this.name = name;
        this.code = code;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }
}
