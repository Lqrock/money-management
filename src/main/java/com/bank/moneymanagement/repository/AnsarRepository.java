package com.bank.moneymanagement.repository;

import com.bank.moneymanagement.model.Ansar;
import com.bank.moneymanagement.model.Ansar;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnsarRepository extends JpaRepository<Ansar, Integer> {
    Ansar findById(int ansarId);

    void deleteById(int ansarId);

    List<Ansar> findByIdBetween(int firstId, int secondId, Sort sort);

    List<Ansar> findByDateBetween(LocalDate from, LocalDate to, Sort sort);


}
