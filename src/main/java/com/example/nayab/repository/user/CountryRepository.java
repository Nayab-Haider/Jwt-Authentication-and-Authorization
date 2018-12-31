package com.example.nayab.repository.user;

import com.example.nayab.domain.user.MyCountry;
import com.example.nayab.domain.user.MyCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<MyCountry,Long> {
}
