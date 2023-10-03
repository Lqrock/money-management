package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Melli;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;


public interface MelliServiceInterface {

    Melli addMelli(Melli melli);

    Melli editMelli(Melli melli) throws EntityNotFoundException;

    void deleteMelli(int melliId) throws EntityNotFoundException;

    List<Melli> getMellisByIdBetween(int from, int to);

    Melli getMelli(int melliId) throws EntityNotFoundException;

    List<Melli> getAllMellis();

    List<Melli> getMellisByDateBetween(LocalDate from, LocalDate to);

}
