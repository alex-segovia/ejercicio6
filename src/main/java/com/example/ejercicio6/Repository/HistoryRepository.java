package com.example.ejercicio6.Repository;

import com.example.ejercicio6.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    //COMPLETAR

}
