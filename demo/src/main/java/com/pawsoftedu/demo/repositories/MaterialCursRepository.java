package com.pawsoftedu.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawsoftedu.demo.entities.MaterialCurs;

@Repository
public interface MaterialCursRepository extends JpaRepository<MaterialCurs, Long> {
   
}
