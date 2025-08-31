package com.journalingapp.smart_journaling_app.service;

import com.journalingapp.smart_journaling_app.dto.JournalRequestDto;
import com.journalingapp.smart_journaling_app.model.Journal;
import com.journalingapp.smart_journaling_app.model.User;
import com.journalingapp.smart_journaling_app.repo.JournalRepository;
import com.journalingapp.smart_journaling_app.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class JournalService {

    private final JournalRepository journalRepository;
    private final UserRepository userRepository;

    public JournalService(JournalRepository journalRepository, UserRepository userRepository) {
        this.journalRepository = journalRepository;
        this.userRepository = userRepository;
    }
    //private final ModelMapper modelMapper;



    public Journal createJournal(JournalRequestDto requestDto){

        User user = userRepository.findByEmail("dummy@example.com")
                .orElseThrow(() -> new RuntimeException("Default user not found"));

        Journal journal = new Journal();
        journal.setUser(user); // wajib isi user
        journal.setTitle(requestDto.getTitle());
        journal.setContent(requestDto.getContent());
        journal.setJournalType(requestDto.getJournalType());
        journal.setEntryDate(requestDto.getEntryDate());

        return journalRepository.save(journal);
    }
}
