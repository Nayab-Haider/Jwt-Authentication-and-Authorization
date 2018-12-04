package com.example.nayab.repository.user;

import com.example.nayab.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    User findUserByResetToken(String resetToken);

    @Transactional
    int deleteByUsername(String username);
}
