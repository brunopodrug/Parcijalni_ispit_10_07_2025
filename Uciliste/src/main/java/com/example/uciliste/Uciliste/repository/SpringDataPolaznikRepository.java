package com.example.uciliste.Uciliste.repository;

import com.example.uciliste.Uciliste.domain.Polaznik;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataPolaznikRepository extends JpaRepository<Polaznik, Long> {
    @EntityGraph(attributePaths = "upisSet")
    List<Polaznik> findAll();
}
