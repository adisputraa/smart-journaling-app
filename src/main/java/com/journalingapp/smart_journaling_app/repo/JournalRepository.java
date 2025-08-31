package com.journalingapp.smart_journaling_app.repo;

import com.journalingapp.smart_journaling_app.model.Journal;
import com.journalingapp.smart_journaling_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JournalRepository extends JpaRepository<Journal, UUID> {

    // Cari jurnal berdasarkan User object
    List<Journal> findByUser(User user);

    // Atau langsung pakai userId
    List<Journal> findByUserId(UUID userId);
}
