package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Saman;
import com.bank.moneymanagement.model.Saman;
import com.bank.moneymanagement.model.Operation;
import com.bank.moneymanagement.repository.SamanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class SamanService implements SamanServiceInterface {

    @Autowired
    SamanRepository samanRepository;

    @Override
    public Saman addSaman(Saman saman) {

        samanRepository.save(saman);

        int samanId = saman.getId();
        Saman previousSaman = samanRepository.findById(samanId - 1);

        int previousBalance = previousSaman.getBalance();
        int amount = saman.getAmount();
        if (saman.getOperation() == Operation.WITHDRAW) {
            saman.setBalance(previousBalance - amount);
        } else if (saman.getOperation() == Operation.DEPOSIT) {
            saman.setBalance(previousBalance + amount);
        }

        samanRepository.save(saman);
        return saman;
    }

    @Override
    public Saman editSaman(Saman saman) throws EntityNotFoundException {
        samanRepository.save(saman);
        return saman;
    }

    @Override
    public void deleteSaman(int samanId) throws EntityNotFoundException {
        samanRepository.deleteById(samanId);
    }

    @Override
    public Saman getSaman(int samanId) throws EntityNotFoundException {
        return samanRepository.findById(samanId);
    }

    public List<Saman> getSamansByIdBetween(int from, int to) {
        return samanRepository.findByIdBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Saman> getAllSamans() {
        return samanRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Saman> getSamansByDateBetween(LocalDate from, LocalDate to) {
        return samanRepository.findByDateBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

}
