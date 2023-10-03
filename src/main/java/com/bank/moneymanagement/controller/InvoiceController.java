package com.bank.moneymanagement.controller;

import com.bank.moneymanagement.model.*;
import com.bank.moneymanagement.service.AnsarService;
import com.bank.moneymanagement.service.EnService;
import com.bank.moneymanagement.service.MelliService;
import com.bank.moneymanagement.service.SamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    private static final String SHOW_ALL_INVOICES = "show-all-invoices";
    private static final String MELLI_INVOICES = "melli_invoices";
    private static final String ANSAR_INVOICES = "ansar_invoices";
    private static final String SAMAN_INVOICES = "saman_invoices";
    private static final String EN_INVOICES = "en_invoices";
    private static final String INVOICES = "invoices";

    @Autowired
    MelliService melliService;

    @Autowired
    AnsarService ansarService;

    @Autowired
    SamanService samanService;

    @Autowired
    EnService enService;


    @PostMapping("/add-melli")
    public ResponseEntity<Melli> addMelli(@RequestBody Melli melli) {
        melliService.addMelli(melli);
        return new ResponseEntity<>(melli, HttpStatus.OK);
    }

    @PostMapping("/add-ansar")
    public ResponseEntity<Ansar> addAnsar(@RequestBody Ansar ansar) {
        ansarService.addAnsar(ansar);
        return new ResponseEntity<>(ansar, HttpStatus.OK);
    }

    @PostMapping("/add-saman")
    public ResponseEntity<Saman> addSaman(@RequestBody Saman saman) {
        samanService.addSaman(saman);
        return new ResponseEntity<>(saman, HttpStatus.OK);
    }

    @PostMapping("/add-en")
    public ResponseEntity<En> addEn(@RequestBody En en) {
        enService.addEn(en);
        return new ResponseEntity<>(en, HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<Melli> updateMelli(@RequestBody Melli Melli) {
//        melliService.editMelli(Melli);
//        return new ResponseEntity<>(Melli, HttpStatus.OK);
//    }


    @GetMapping("/get")
    public ResponseEntity<Bank> getInvoice(@RequestParam int id, @RequestParam String cardName) {
        if (cardName.contains("melli")) {
            return new ResponseEntity<>(melliService.getMelli(id), HttpStatus.OK);
        }
        if (cardName.contains("ansar") || cardName.contains("dadash")) {
            return new ResponseEntity<>(ansarService.getAnsar(id), HttpStatus.OK);
        }
        if (cardName.contains("eghtesad")) {
            return new ResponseEntity<>(enService.getEn(id), HttpStatus.OK);
        }
        if (cardName.contains("saman")) {
            return new ResponseEntity<>(samanService.getSaman(id), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delete")
    public String deleteMelli(@RequestParam int id, @RequestParam String cardName, Model model) {
        if (cardName.contains("melli")) {
            melliService.deleteMelli(id);
            model.addAttribute(INVOICES, melliService.getAllMellis());
        }
        if (cardName.contains("ansar") || cardName.contains("dadash")) {
            ansarService.deleteAnsar(id);
            model.addAttribute(INVOICES, ansarService.getAllAnsars());
        }
        if (cardName.contains("eghtesad")) {
            enService.deleteEn(id);
            model.addAttribute(INVOICES, enService.getAllEns());
        }
        if (cardName.contains("saman")) {
            samanService.deleteSaman(id);
            model.addAttribute(INVOICES, samanService.getAllSamans());
        }

        return SHOW_ALL_INVOICES;
    }














//
//    @GetMapping("/get-all")
//    public String getAllMellis(Model model) {
//        List<Melli> Mellis = melliService.getAllMellis();
//        model.addAttribute(MelliS, Mellis);
//        return SHOW_ALL_MelliS;
//    }
//
//    @GetMapping("/get-all-by-id")
//    public String getAllMellisById(Model model, @RequestParam int a, @RequestParam int b) {
//        List<Melli> Mellis = melliService.getMellisByIdBetween(a, b);
//        model.addAttribute(MelliS, Mellis);
//        return SHOW_ALL_MelliS;
//    }
//
//    @GetMapping("/get-all-by-date")
//    public String getAllMellisByDateBetween(Model model, @RequestParam LocalDate from, @RequestParam LocalDate to) {
//        List<Melli> Mellis = melliService.getMellisByDateBetween(from, to);
//        model.addAttribute(MelliS, Mellis);
//        return SHOW_ALL_MelliS;
//    }

    @GetMapping("/choose")
    public String chooseAccount() {
        return "choose-account";
    }
//

    @PostMapping("/show-invoices-by-card-name")
    public String get(@RequestParam String name, Model model) {

        if (name.equals(MELLI_INVOICES)) {
            model.addAttribute(INVOICES, melliService.getAllMellis());
        }
        if (name.equals(ANSAR_INVOICES)) {
            model.addAttribute(INVOICES, ansarService.getAllAnsars());
        }
        if (name.equals(SAMAN_INVOICES)) {
            model.addAttribute(INVOICES, samanService.getAllSamans());
        }
        if (name.equals(EN_INVOICES)) {
            model.addAttribute(INVOICES, enService.getAllEns());
        }
        return SHOW_ALL_INVOICES;
    }

}
