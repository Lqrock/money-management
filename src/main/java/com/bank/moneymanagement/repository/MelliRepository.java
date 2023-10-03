package com.bank.moneymanagement.repository;

import com.bank.moneymanagement.model.Melli;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MelliRepository extends JpaRepository<Melli, Integer> {
    Melli findById(int invoiceId);

    void deleteById(int invoiceId);

    List<Melli> findByIdBetween(int firstId, int secondId, Sort sort);

    List<Melli> findByDateBetween(LocalDate from, LocalDate to, Sort sort);


}
