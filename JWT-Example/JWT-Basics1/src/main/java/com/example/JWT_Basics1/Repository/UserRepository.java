package com.example.JWT_Basics1.Repository;

import com.example.JWT_Basics1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

//    Optional<User> findByProviderIdandProviderType(String providerId, AuthProviderType providerType);
}
