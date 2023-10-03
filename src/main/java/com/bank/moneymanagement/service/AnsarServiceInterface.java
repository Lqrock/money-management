package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Ansar;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface AnsarServiceInterface {

    Ansar addAnsar(Ansar ansar);

    Ansar editAnsar(Ansar ansar) throws EntityNotFoundException;

    void deleteAnsar(int ansarId) throws EntityNotFoundException;

    List<Ansar> getAnsarsByIdBetween(int from, int to);

    Ansar getAnsar(int ansarId) throws EntityNotFoundException;

    List<Ansar> getAllAnsars();

    List<Ansar> getAnsarsByDateBetween(LocalDate from, LocalDate to);
}
