package service;


import dao.Employee;
import dto.EmployeeDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<?> getAllEmployee(){
        List<Employee> employeeList=employeeRepository.findAll();
        List<EmployeeDto> employeeDtos=employeeList.stream().map(employee -> employee.convertToListDto()).collect(
            Collectors.toList());
        return ResponseEntity.ok(employeeDtos);
    }

}
