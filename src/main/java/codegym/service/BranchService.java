package codegym.service;

import codegym.model.Branch;
import codegym.repository.IBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BranchService implements IBranchService {
    @Autowired
    IBranchRepo iBranchRepo;

    @Override
    public ArrayList<Branch> findAll() {
        return (ArrayList<Branch>) iBranchRepo.findAll();
    }

    @Override
    public Branch findById(long id) {
        return iBranchRepo.findById(id).get();
    }
}
