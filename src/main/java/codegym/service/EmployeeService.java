package codegym.service;

import codegym.model.Employee;
import codegym.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    @Override
    public Employee save(Employee employee) {
        return iEmployeeRepo.save(employee);
    }

    @Override
    public Employee findById(long id) {
        return iEmployeeRepo.findById(id).get();
    }

    @Override
    public ArrayList<Employee> findAll() {
        return (ArrayList<Employee>) iEmployeeRepo.findAll();
    }

    @Override
    public void Delete(Employee employee) {
        iEmployeeRepo.delete(employee);
    }
}
