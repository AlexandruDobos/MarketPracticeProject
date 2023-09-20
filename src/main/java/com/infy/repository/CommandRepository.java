package com.infy.repository;

import com.infy.dto.CommandDTO;
import com.infy.entity.Command;
import com.infy.exception.InfyBankException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Integer> {
    public Command getById(Integer id);
    public List<Command> getCommandsByCustomerId(Integer customerId);

    public List<Command> findByDateBetween(Date data1, Date data2);
    @Query("SELECT c FROM Command c WHERE CAST(c.date AS DATE) = CAST(:date AS DATE)")
    public List<Command> findByDate(Date date);
}
