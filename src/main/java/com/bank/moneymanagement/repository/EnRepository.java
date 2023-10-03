package com.bank.moneymanagement.repository;

import com.bank.moneymanagement.model.En;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EnRepository extends JpaRepository<En, Integer> {
    En findById(int invoiceId);

    void deleteById(int invoiceId);

    List<En> findByIdBetween(int firstId, int secondId, Sort sort);

    List<En> findByDateBetween(LocalDate from, LocalDate to, Sort sort);


}
