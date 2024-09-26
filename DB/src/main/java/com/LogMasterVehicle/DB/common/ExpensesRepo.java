package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.ExpensesLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpensesRepo extends JpaRepository<ExpensesLog, Integer> {
    Optional<ExpensesLog> findById(Integer id);
    List<ExpensesLog> findByEntryType(String entryType);
    List<ExpensesLog> findByName(String name);
    List<ExpensesLog> findByAmount(String amount);
}
