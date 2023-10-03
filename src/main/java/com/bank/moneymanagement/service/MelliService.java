package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Melli;
import com.bank.moneymanagement.model.Melli;
import com.bank.moneymanagement.model.Operation;
import com.bank.moneymanagement.repository.MelliRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class MelliService implements MelliServiceInterface {

    @Autowired
    MelliRepository melliRepository;

    @Override
    public Melli addMelli(Melli melli) {

        melliRepository.save(melli);

        int melliId = melli.getId();
        Melli previousMelli = melliRepository.findById(melliId - 1);

        int previousBalance = previousMelli.getBalance();
        int amount = melli.getAmount();
        if (melli.getOperation() == Operation.WITHDRAW) {
            melli.setBalance(previousBalance - amount);
        } else if (melli.getOperation() == Operation.DEPOSIT) {
            melli.setBalance(previousBalance + amount);
        }

        melliRepository.save(melli);
        return melli;
    }

    @Override
    public Melli editMelli(Melli melli) throws EntityNotFoundException {
        melliRepository.save(melli);
        return melli;
    }

    @Override
    public void deleteMelli(int melliId) throws EntityNotFoundException {
        melliRepository.deleteById(melliId);
    }

    @Override
    public Melli getMelli(int melliId) throws EntityNotFoundException {
        return melliRepository.findById(melliId);
    }

    public List<Melli> getMellisByIdBetween(int from, int to) {
        return melliRepository.findByIdBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Melli> getAllMellis() {
        return melliRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Melli> getMellisByDateBetween(LocalDate from, LocalDate to) {
        return melliRepository.findByDateBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

}
