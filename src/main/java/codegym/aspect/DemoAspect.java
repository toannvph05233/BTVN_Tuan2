package codegym.aspect;

import codegym.service.IEmployeeService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component

public class DemoAspect {
    @Autowired
    IEmployeeService iEmployeeService;

    @Before(value = "execution(* codegym.service.EmployeeService.findAll())")
    public void logger() throws Exception {
        throw new Exception("list clear");
    }
}
