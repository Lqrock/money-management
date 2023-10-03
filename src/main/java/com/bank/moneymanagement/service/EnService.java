package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.En;
import com.bank.moneymanagement.model.En;
import com.bank.moneymanagement.model.Operation;
import com.bank.moneymanagement.repository.EnRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EnService implements EnServiceInterface {

    @Autowired
    EnRepository enRepository;

    @Override
    public En addEn(En en) {

        enRepository.save(en);

        int enId = en.getId();
        En previousEn = enRepository.findById(enId - 1);

        int previousBalance = previousEn.getBalance();
        int amount = en.getAmount();
        if (en.getOperation() == Operation.WITHDRAW) {
            en.setBalance(previousBalance - amount);
        } else if (en.getOperation() == Operation.DEPOSIT) {
            en.setBalance(previousBalance + amount);
        }

        enRepository.save(en);
        return en;
    }

    @Override
    public En editEn(En en) throws EntityNotFoundException {
        enRepository.save(en);
        return en;
    }

    @Override
    public void deleteEn(int enId) throws EntityNotFoundException {
        enRepository.deleteById(enId);
    }

    @Override
    public En getEn(int enId) throws EntityNotFoundException {
        return enRepository.findById(enId);
    }

    public List<En> getEnsByIdBetween(int from, int to) {
        return enRepository.findByIdBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<En> getAllEns() {
        return enRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<En> getEnsByDateBetween(LocalDate from, LocalDate to) {
        return enRepository.findByDateBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

}
