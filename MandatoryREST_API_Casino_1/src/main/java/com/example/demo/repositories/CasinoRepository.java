package com.example.demo.repositories;

import com.example.demo.models.Casino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasinoRepository extends JpaRepository<Casino, Long> {
}
