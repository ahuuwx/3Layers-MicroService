package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

@RestController
public class Controller {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/")
    public String home() {
        return "Hello from Employee Service running at port: " + env.getProperty("local.server.port");
    }
    @RequestMapping(value = "/employees")
    public ResponseEntity<?> getAllEmployees() throws Exception {
        return employeeService.getAllEmployee();
    }



}
