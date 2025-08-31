package com.journalingapp.smart_journaling_app.repo;

import com.journalingapp.smart_journaling_app.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JournalRepository extends JpaRepository<Journal, UUID> {
}
