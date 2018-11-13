package com.example.nayab.repository;

import com.example.nayab.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
