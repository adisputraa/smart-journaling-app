package com.journalingapp.smart_journaling_app.controller;

import com.journalingapp.smart_journaling_app.dto.JournalRequestDto;
import com.journalingapp.smart_journaling_app.model.Journal;
import com.journalingapp.smart_journaling_app.service.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/journals")
public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping
    public ResponseEntity<Journal> createJournal(@RequestBody JournalRequestDto journalRequestDto){
        Journal createJournal = journalService.createJournal(journalRequestDto);
        return new ResponseEntity<>(createJournal, HttpStatus.CREATED);
    }
}
