package codegym.service;

import codegym.model.Branch;
import codegym.model.Employee;

import java.util.ArrayList;

public interface IBranchService {
    ArrayList<Branch> findAll();
    Branch findById(long id);

}
