package com.example.GestionDeBibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeBibliotheque.model.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre , Long> {

}
