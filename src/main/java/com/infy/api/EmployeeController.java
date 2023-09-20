package com.infy.api;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;
import com.infy.exception.InfyBankException;
import com.infy.service.impl.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/market/employees")
@Validated
public class EmployeeController {

    private EmployeeService employeeService;

    private ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() throws InfyBankException {
        List<Employee> employees = employeeService.getAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDTOList.add(this.modelMapper.map(employee, EmployeeDTO.class));
        }
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> get(@PathVariable Integer employeeId) throws InfyBankException {
        Employee employee = employeeService.get(employeeId);
        return new ResponseEntity<>(this.modelMapper.map(employee, EmployeeDTO.class), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO employeeDTO) throws InfyBankException {
        Employee employee = employeeService.save(this.modelMapper.map(employeeDTO, Employee.class));
        return new ResponseEntity<>(this.modelMapper.map(employee, EmployeeDTO.class), HttpStatus.CREATED);
    }


    @PatchMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> partialUpdate(@PathVariable Integer employeeId, @RequestBody Map<String, Object> employeeUpdates) throws InfyBankException {
        Employee employee = employeeService.partialUpdate(employeeId, employeeUpdates);
        return new ResponseEntity<>(this.modelMapper.map(employee, EmployeeDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> delete(@PathVariable Integer employeeId) throws InfyBankException {
        Employee employee = employeeService.delete(employeeId);
        return new ResponseEntity<>(this.modelMapper.map(employee, EmployeeDTO.class), HttpStatus.OK);
    }
}
