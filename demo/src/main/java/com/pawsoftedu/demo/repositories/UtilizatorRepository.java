package com.pawsoftedu.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawsoftedu.demo.entities.Utilizator;

@Repository
public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {
    
}
