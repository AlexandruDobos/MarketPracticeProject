package com.infy.service.impl;

import com.infy.entity.Employee;
import com.infy.exception.InfyBankException;
import com.infy.repository.EmployeeRepository;
import com.infy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service(value = "employeeService")
@Transactional
public class EmployeeService implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() throws InfyBankException {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new InfyBankException("Service.EMPLOYEES_NOT_FOUND");
        }
        return employees;
    }

    @Override
    public Employee get(Integer employeeId) throws InfyBankException {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = optional.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND"));
        return employee;
    }

    @Override
    public Employee save(Employee employee) throws InfyBankException {
        if (!employeeRepository.existsByEmail(employee.getEmail())) {
            employeeRepository.save(employee);
            return employee;
        } else {
            throw new InfyBankException("Service.EMPLOYEE_ALREADY_EXISTS");
        }
    }

    @Override
    public Employee partialUpdate(Integer employeeId, Map<String, Object> updates) throws InfyBankException {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = optional.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND"));
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "firstName": {
                        employee.setFirstName(entry.getValue().toString());
                        break;
                    }
                    case "lastName": {
                        employee.setLastName(entry.getValue().toString());
                        break;
                    }
                    case "email": {
                        employee.setEmail(entry.getValue().toString());
                        break;
                    }
                    case "phone": {
                        employee.setPhone(entry.getValue().toString());
                        break;
                    }
                    case "officeCode": {
                        employee.setOfficeCode(entry.getValue().toString());
                        break;
                    }
                    case "jobTitle": {
                        employee.setJobTitle(entry.getValue().toString());
                        break;
                    }
                    case "dateOfJoin": {
                        employee.setDateOfJoin((Date) entry.getValue());
                        break;
                    }
                }
            }
        }
        return employee;
    }

    @Override
    public Employee delete(Integer employeeId) throws InfyBankException {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = optional.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND"));
        employee.setIsActive(0);
//        employeeRepository.delete(employee);
        return employee;
    }
}
