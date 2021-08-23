package codegym.service;

import codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface IEmployeeService {
    Employee save(Employee employee);

    Employee findById(long id);

    ArrayList<Employee> findAll();

    void Delete(Employee customer);

}
