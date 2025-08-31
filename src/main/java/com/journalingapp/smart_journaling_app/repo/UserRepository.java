package com.journalingapp.smart_journaling_app.repo;


import com.journalingapp.smart_journaling_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
