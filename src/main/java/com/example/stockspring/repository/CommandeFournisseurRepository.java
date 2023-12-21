package com.example.stockspring.repository;

import java.util.List;
import java.util.Optional;

import com.example.stockspring.model.CommandeClient;
import com.example.stockspring.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

    List<CommandeClient> findAllByFournisseurId(Integer id);
}
