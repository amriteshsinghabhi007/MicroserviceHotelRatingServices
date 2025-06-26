package com.micorservices.userservices.Creating.the.user.service.repository;

import com.micorservices.userservices.Creating.the.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
