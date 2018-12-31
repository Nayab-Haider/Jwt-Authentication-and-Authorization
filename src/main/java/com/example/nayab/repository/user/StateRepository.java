package com.example.nayab.repository.user;

import com.example.nayab.domain.user.MyCountry;
import com.example.nayab.domain.user.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {

    List<State> findByCountry(MyCountry country);
}
