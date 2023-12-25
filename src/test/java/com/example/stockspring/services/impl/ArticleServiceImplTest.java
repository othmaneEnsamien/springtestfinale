package com.example.stockspring.services.impl;


import com.example.stockspring.dto.ArticleDto;
import com.example.stockspring.dto.CategoryDto;
import com.example.stockspring.dto.LigneVenteDto;
import com.example.stockspring.services.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {



    @Autowired
    private ArticleService service;

    @Test
    public void testSave() {
        // Mocking data
        ArticleDto articleDto = ArticleDto.builder()
                .id(1)
                .codeArticle("TestCode")
                .designation("TestDesignation")
                .prixUnitaireHt(new BigDecimal("10.00"))
                .tauxTva(new BigDecimal("0.20"))
                .prixUnitaireTtc(new BigDecimal("12.00"))
                .photo("test.jpg")
                .idEntreprise(123)
                .category(CategoryDto.builder().id(1).build())
                .build();

        // Test
        ArticleDto savedArticle = service.save(articleDto);

        // Verify
        assertNotNull(savedArticle);
        assertEquals(1, savedArticle.getId());
        assertEquals("TestCode", savedArticle.getCodeArticle());
        assertEquals("TestDesignation", savedArticle.getDesignation());
        assertEquals(new BigDecimal("10.00"), savedArticle.getPrixUnitaireHt());
        assertEquals(new BigDecimal("0.20"), savedArticle.getTauxTva());
        assertEquals(new BigDecimal("12.00"), savedArticle.getPrixUnitaireTtc());
        assertEquals("test.jpg", savedArticle.getPhoto());
        assertEquals(123, savedArticle.getIdEntreprise());
        CategoryDto savedCategory = savedArticle.getCategory();
        assertNotNull(savedCategory);
        assertEquals(1, savedCategory.getId());

    }

    @Test
    public void testFindById() {
        // Test
        ArticleDto foundArticle = service.findById(1);

        // Verify
        assertNotNull(foundArticle);
        assertEquals(1, foundArticle.getId());
        // Add more assertions based on your expectations
    }
    @Test
    public void testFindByCodeArticle() {
        // Test
        ArticleDto foundArticle = service.findByCodeArticle("TestCode");

        // Verify
        assertNotNull(foundArticle);
        assertEquals("TestCode", foundArticle.getCodeArticle());
    }

    @Test
    public void testFindAll() {
        // Test
        List<ArticleDto> articles = service.findAll();

        // Verify
        assertNotNull(articles);
        assertFalse(articles.isEmpty());
    }
    @Test
    public void testDelete() {
        // Test
        service.delete(1);
    }

    @Test
    public void testFindHistoriqueVentes() {
        // Test
        List<LigneVenteDto> historiqueVentes = service.findHistoriqueVentes(1);
        // Verify
        assertNotNull(historiqueVentes);
    }




}