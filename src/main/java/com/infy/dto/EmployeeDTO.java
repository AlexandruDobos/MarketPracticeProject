package com.infy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {
    private Integer id;
    @NotNull(message = "{employee.firstName.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message = "{employee.firstName.invalid}")
    private String firstName;
    @NotNull(message = "{employee.lastName.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message = "{employee.lastName.invalid}")
    private String lastName;
    @NotNull(message = "{employee.email.absent}")
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+", message = "{employee.email.invalid}")
    private String email;
    @NotNull(message = "{employee.phone.absent}")
    @Pattern(regexp="[0-9]{10}", message = "{employee.phone.invalid}")
    private String phone;
    @NotNull(message = "{employee.officeCode.absent}")
    private String officeCode;
    @NotNull(message = "{employee.jobTitle.absent}")
    private String jobTitle;
    @NotNull(message = "{employee.dateOfJoin.absent}")
    private Date dateOfJoin;
    private Integer isActive;
}
