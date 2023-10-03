package com.bank.moneymanagement.repository;

import com.bank.moneymanagement.model.Saman;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SamanRepository extends JpaRepository<Saman, Integer> {
    Saman findById(int invoiceId);

    void deleteById(int invoiceId);

    List<Saman> findByIdBetween(int firstId, int secondId, Sort sort);

    List<Saman> findByDateBetween(LocalDate from, LocalDate to, Sort sort);


}
