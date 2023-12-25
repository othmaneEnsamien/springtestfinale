package com.example.stockspring.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import com.example.stockspring.dto.ArticleDto;
import com.example.stockspring.dto.CategoryDto;
import com.example.stockspring.dto.LigneVenteDto;
import com.example.stockspring.dto.VentesDto;
import com.example.stockspring.services.VentesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VentesServiceImplTest {

    @Autowired
    private VentesService service;

    @Test
    public void testSave() {
        // Mocking data using the builder pattern
        VentesDto ventesDto = VentesDto.builder()
                .code("TestCode")
                .idEntreprise(123)
                .ligneVentes(Collections.singletonList(
                        LigneVenteDto.builder()
                                .article(ArticleDto.builder()
                                        .id(10)
                                        .category(CategoryDto.builder().id(2).build()) // Include category
                                        .build())
                                .quantite(new BigDecimal("5"))
                                .build()
                ))
                .build();

        // Test
        VentesDto savedVentes = service.save(ventesDto);

        // Verify
        assertNotNull(savedVentes);
        assertNotNull(savedVentes.getId());
        assertEquals("TestCode", savedVentes.getCode());
        assertEquals(123, savedVentes.getIdEntreprise());

        // Verify LigneVente
        List<LigneVenteDto> ligneVentes = savedVentes.getLigneVentes();
        assertNotNull(ligneVentes);
        assertFalse(ligneVentes.isEmpty());
        LigneVenteDto savedLigneVente = ligneVentes.get(0);
        assertNotNull(savedLigneVente);
        assertNotNull(savedLigneVente.getId());
        assertEquals(102, savedLigneVente.getArticle().getId()); // Corrected ID
        assertEquals(2, savedLigneVente.getArticle().getCategory().getId()); // Include category ID
        assertEquals(new BigDecimal("5"), savedLigneVente.getQuantite());
    }



    @Test
    public void testFindById() {
        // Test
        VentesDto foundVentes = service.findById(1);

        // Verify
        assertNotNull(foundVentes);
        assertEquals(1, foundVentes.getId());
        // Add more assertions based on your expectations
    }

    @Test
    public void testFindByCode() {
        // Test
        VentesDto foundVentes = service.findByCode("TestCode");

        // Verify
        assertNotNull(foundVentes);
        assertEquals("TestCode", foundVentes.getCode());
    }

    @Test
    public void testFindAll() {
        // Test
        List<VentesDto> ventesList = service.findAll();

        // Verify
        assertNotNull(ventesList);
        assertFalse(ventesList.isEmpty());
    }

    @Test
    public void testDelete() {
        // Test
        service.delete(1);
    }

    // Add more tests as needed
}

