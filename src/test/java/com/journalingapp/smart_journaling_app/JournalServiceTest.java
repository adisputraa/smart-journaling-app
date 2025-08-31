package com.journalingapp.smart_journaling_app;

import com.journalingapp.smart_journaling_app.dto.JournalRequestDto;
import com.journalingapp.smart_journaling_app.model.Journal;
import com.journalingapp.smart_journaling_app.model.User;
import com.journalingapp.smart_journaling_app.repo.JournalRepository;
import com.journalingapp.smart_journaling_app.repo.UserRepository;
import com.journalingapp.smart_journaling_app.service.JournalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JournalServiceTest {

    @Mock
    private JournalRepository journalRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private JournalService journalService;
    private User dummyUser;
    private JournalRequestDto journalRequestDto;

    @BeforeEach
    void setUp(){
        dummyUser = new User();
        dummyUser.setEmail("dummy@example.com");

        journalRequestDto = new JournalRequestDto();
        journalRequestDto.setTitle("Test Title");
        journalRequestDto.setContent("Test Content");
        journalRequestDto.setEntryDate(LocalDate.now());
    }

    @Test
    void whenCreateJournal_thenReturnsSavedJournal() {
        // Given
        Journal journal = new Journal();
        journal.setTitle(journalRequestDto.getTitle());
        journal.setContent(journalRequestDto.getContent());
        journal.setEntryDate(journalRequestDto.getEntryDate());
        journal.setUser(dummyUser);

        when(userRepository.findByEmail("dummy@example.com")).thenReturn(Optional.of(dummyUser));
        when(journalRepository.save(any(Journal.class))).thenReturn(journal);

        // When
        Journal createdJournal = journalService.createJournal(journalRequestDto);

        // Then
        assertThat(createdJournal).isNotNull();
        assertThat(createdJournal.getTitle()).isEqualTo("Test Title");
    }
}
