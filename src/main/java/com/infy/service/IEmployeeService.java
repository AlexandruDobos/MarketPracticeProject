package com.infy.service;


import com.infy.entity.Employee;
import com.infy.exception.InfyBankException;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    List<Employee> getAll() throws InfyBankException;

    Employee get(Integer employeeId) throws InfyBankException;

    Employee save(Employee employee) throws InfyBankException;

    Employee partialUpdate(Integer employeeId, Map<String, Object> updates) throws InfyBankException;

    Employee delete(Integer employeeId) throws InfyBankException;
}
