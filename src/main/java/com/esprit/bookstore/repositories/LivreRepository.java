package com.esprit.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.bookstore.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer>{

}
