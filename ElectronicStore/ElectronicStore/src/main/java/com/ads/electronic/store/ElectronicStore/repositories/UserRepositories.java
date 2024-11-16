package com.ads.electronic.store.ElectronicStore.repositories;

import com.ads.electronic.store.ElectronicStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositories extends JpaRepository<User,String>{

    Optional<User> findByEmail(String email);// where clause
    Optional<User> findByNameContaining(String keyword);// like query
}
