package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Ansar;
import com.bank.moneymanagement.model.Ansar;
import com.bank.moneymanagement.model.Operation;
import com.bank.moneymanagement.repository.AnsarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class AnsarService implements AnsarServiceInterface {

    @Autowired
    AnsarRepository ansarRepository;

    @Override
    public Ansar addAnsar(Ansar ansar) {

        ansarRepository.save(ansar);

        int ansarId = ansar.getId();
        Ansar previousAnsar = ansarRepository.findById(ansarId - 1);

        int previousBalance = previousAnsar.getBalance();
        int amount = ansar.getAmount();
        if (ansar.getOperation() == Operation.WITHDRAW) {
            ansar.setBalance(previousBalance - amount);
        } else if (ansar.getOperation() == Operation.DEPOSIT) {
            ansar.setBalance(previousBalance + amount);
        }

        ansarRepository.save(ansar);
        return ansar;
    }

    @Override
    public Ansar editAnsar(Ansar ansar) throws EntityNotFoundException {
        ansarRepository.save(ansar);
        return ansar;
    }

    @Override
    public void deleteAnsar(int ansarId) throws EntityNotFoundException {
        ansarRepository.deleteById(ansarId);
    }

    @Override
    public Ansar getAnsar(int ansarId) throws EntityNotFoundException {
        return ansarRepository.findById(ansarId);
    }

    public List<Ansar> getAnsarsByIdBetween(int from, int to) {
        return ansarRepository.findByIdBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Ansar> getAllAnsars() {
        return ansarRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Ansar> getAnsarsByDateBetween(LocalDate from, LocalDate to) {
        return ansarRepository.findByDateBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

}
