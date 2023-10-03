package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.En;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface EnServiceInterface {

    En addEn(En en);

    En editEn(En en) throws EntityNotFoundException;

    void deleteEn(int enId) throws EntityNotFoundException;

    List<En> getEnsByIdBetween(int from, int to);

    En getEn(int enId) throws EntityNotFoundException;

    List<En> getAllEns();

    List<En> getEnsByDateBetween(LocalDate from, LocalDate to);
}
