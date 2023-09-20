package com.infy.api;

import com.infy.dto.CommandDTO;
import com.infy.entity.Command;
import com.infy.exception.InfyBankException;
import com.infy.service.impl.CommandService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/market/commands")
@Validated
public class CommandController {
    private CommandService commandService;

    private ModelMapper modelMapper;

    @Autowired
    public CommandController(CommandService commandService, ModelMapper modelMapper) {
        this.commandService = commandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{commandId}")
    public ResponseEntity<CommandDTO> get(@PathVariable @Min(value = 1, message = "Command id should be minimum 1") Integer commandId) throws InfyBankException {
        Command command = commandService.get(commandId);
        return new ResponseEntity<>(this.modelMapper.map(command, CommandDTO.class), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CommandDTO>> get(@RequestBody Map<String, Object> dates) throws InfyBankException, ParseException {
        List<Command> commandList = commandService.getByDate(dates);
        List<CommandDTO> commandDTOList = new ArrayList<>();
        for(Command command : commandList){
            commandDTOList.add(this.modelMapper.map(command, CommandDTO.class));
        }
        return new ResponseEntity<>(commandDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CommandDTO>> getAll (@RequestBody Map<String, Object> dates) throws InfyBankException, ParseException {
        List<Command> commandList = commandService.getAllBetweenTwoDates(dates);
        List<CommandDTO> commandDTOList = new ArrayList<>();
        for(Command command : commandList){
            commandDTOList.add(this.modelMapper.map(command, CommandDTO.class));
        }
        return new ResponseEntity<>(commandDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommandDTO> save(@Valid @RequestBody CommandDTO commandDTO) throws InfyBankException {
        Command command = commandService.save(this.modelMapper.map(commandDTO, Command.class));
        return new ResponseEntity<>(this.modelMapper.map(command, CommandDTO.class), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{commandId}")
    public ResponseEntity<CommandDTO> partialUpdate(@PathVariable @Min(value = 1, message = "Command id should be minimum 1") Integer commandId, @RequestBody Map<String, Object> commandUpdates) throws InfyBankException, ParseException {
        Command command = commandService.partialUpdate(commandId, commandUpdates);
        return new ResponseEntity<>(this.modelMapper.map(command, CommandDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllCommands/{customerId}")
    public ResponseEntity<List<CommandDTO>> getAllCommands(@PathVariable @Min(value = 1, message = "Customer id should be minimum 1") Integer customerId) throws InfyBankException {
        List<Command> customerCommands = commandService.getAll(customerId);
        List<CommandDTO> commandDTOList = new ArrayList<>();
        for(Command command : customerCommands){
            commandDTOList.add(this.modelMapper.map(command, CommandDTO.class));
        }
        return new ResponseEntity<>(commandDTOList, HttpStatus.OK);
    }

}
