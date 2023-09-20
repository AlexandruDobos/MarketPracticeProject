package com.infy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private int id;
    @NotNull(message = "{customer.firstName.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message = "{customer.firstName.invalid}")
    private String firstName;
    @NotNull(message = "{customer.lastName.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message = "{customer.lastName.invalid}")
    private String lastName;
    @NotNull(message = "{customer.email.absent}")
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+", message = "{customer.email.invalid}")
    private String email;
    @NotNull(message = "{customer.phone.absent}")
    @Pattern(regexp="[0-9]{10}", message = "{customer.phone.invalid}")
    private String phone;
    @NotNull(message = "{customer.address.absent}")
    @Pattern(regexp="[A-Za-z0-9]+( [A-Za-z0-9]+)*", message = "{customer.address.invalid}")
    private String address;
    @NotNull(message = "{customer.city.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message = "{customer.city.invalid}")
    private String city;
    @NotNull(message = "{customer.state.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message = "{customer.state.invalid}")
    private String state;
    @NotNull(message = "{customer.postalCode.absent}")
    @Pattern(regexp="[0-9]+", message = "{customer.postalCode.invalid}")
    private String postalCode;
    @NotNull(message = "{customer.country.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message = "{customer.country.invalid}")
    private String country;

//    @NotNull(message = "{customer.commandList.absent}")
    private List<CommandDTO> commandList;
    private int isActive;
    public CustomerDTO() {
    }

    public CustomerDTO(int id, String firstName, String lastName, String email, String phone, String address, String city, String state, String postalCode, String country, List<CommandDTO> commandList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.commandList = commandList;
    }
}
