package com.infy.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String phone;
    @Column(name = "office_code")
    private String officeCode;
    @Column(name = "job_title")
    private String jobTitle;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_join")
    private Date dateOfJoin;
    @Column(name = "is_active")
    private Integer isActive;

/*
    public static Employee prepareEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        employee.setOfficeCode(employeeDTO.getOfficeCode());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setDateOfJoin(employeeDTO.getDateOfJoin());
        return employee;
    }

    public static EmployeeDTO prepareDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setOfficeCode(employee.getOfficeCode());
        employeeDTO.setJobTitle(employee.getJobTitle());
        employeeDTO.setDateOfJoin(employee.getDateOfJoin());
        return employeeDTO;
    }

    public static List<Employee> prepareEntityList(List<EmployeeDTO> employeeDTOList) {
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeDTOList) {
            Employee employee = Employee.prepareEntity(employeeDTO);
            employeeList.add(employee);
        }
        return employeeList;
    }

    public static List<EmployeeDTO> prepareDTOList(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = Employee.prepareDTO(employee);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

 */
}
