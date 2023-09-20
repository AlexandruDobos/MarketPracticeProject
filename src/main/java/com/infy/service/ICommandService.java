package com.infy.service;

import com.infy.entity.Command;
import com.infy.entity.Product;
import com.infy.exception.InfyBankException;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ICommandService {

    Command save(Command command) throws InfyBankException;

    Command get(Integer commandId) throws InfyBankException;

    Command partialUpdate(Integer commandId, Map<String, Object> updates) throws InfyBankException, ParseException;

    List<Command> getAll(Integer customerId) throws InfyBankException;

    List<Command> getByDate(Map<String, Object> dates) throws ParseException;

    List<Command> getAllBetweenTwoDates(Map<String, Object> dates) throws ParseException;
}
