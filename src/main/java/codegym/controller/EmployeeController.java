package codegym.controller;

import codegym.model.Branch;
import codegym.model.Employee;
import codegym.service.IBranchService;
import codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IBranchService iBranchService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iEmployeeService.findAll());
        return modelAndView;
    }

    @ModelAttribute
    public ArrayList<Branch> listBranch() {
        return iBranchService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("em", new Employee());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message",e.getMessage());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("em") Employee employee,
                               BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        iEmployeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        return modelAndView;


    }
}
