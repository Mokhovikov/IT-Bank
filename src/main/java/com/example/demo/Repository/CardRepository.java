package com.example.demo.Repository;

import com.example.demo.Models.Card;
import com.example.demo.Models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, String> {
    Optional<Card> findByEmail(String email);

    Iterable<Card> findAllByEmail(String email);

    Optional<Card> findByAccount(String account);
}
