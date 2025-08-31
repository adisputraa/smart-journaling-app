package com.journalingapp.smart_journaling_app.service;

import com.journalingapp.smart_journaling_app.dto.JournalRequestDto;
import com.journalingapp.smart_journaling_app.model.Journal;
import com.journalingapp.smart_journaling_app.repo.JournalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class JournalService {

    private final JournalRepository journalRepository;
    private final ModelMapper modelMapper;

    public JournalService(JournalRepository journalRepository, ModelMapper modelMapper) {
        this.journalRepository = journalRepository;
        this.modelMapper = modelMapper;
    }

    public Journal createJournal(JournalRequestDto requestDto){
        // Otomatis memetakan data dari DTO ke entitas Journal
        Journal journal = modelMapper.map(requestDto, Journal.class);
        return journalRepository.save(journal);
    }
}
