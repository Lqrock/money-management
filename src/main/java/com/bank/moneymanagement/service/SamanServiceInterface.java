package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Saman;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface SamanServiceInterface {

    Saman addSaman(Saman saman);

    Saman editSaman(Saman saman) throws EntityNotFoundException;

    void deleteSaman(int samanId) throws EntityNotFoundException;

    List<Saman> getSamansByIdBetween(int from, int to);

    Saman getSaman(int samanId) throws EntityNotFoundException;

    List<Saman> getAllSamans();

    List<Saman> getSamansByDateBetween(LocalDate from, LocalDate to);
}
