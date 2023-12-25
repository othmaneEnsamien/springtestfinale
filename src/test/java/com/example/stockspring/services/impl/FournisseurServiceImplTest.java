package com.example.stockspring.services.impl;

import com.example.stockspring.dto.AdresseDto;
import com.example.stockspring.dto.FournisseurDto;
import com.example.stockspring.services.FournisseurService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest {

    @Autowired
    private FournisseurService fournisseurService;

    @Test
    public void testSave() {
        FournisseurDto fournisseurDto = FournisseurDto.builder()
                .nom("string")
                .prenom("string")
                .adresse(AdresseDto.builder()
                        .adresse1("string")
                        .adresse2("string")
                        .ville("string")
                        .codePostale("string")
                        .pays("string")
                        .build())
                .photo("string")
                .mail("string")
                .numTel("string")
                .idEntreprise(0)
                .build();
        // Test
        FournisseurDto savedFournisseur = fournisseurService.save(fournisseurDto);

        // Verify
        assertNotNull(savedFournisseur);
        assertNotNull(savedFournisseur.getId());
        assertEquals("string", savedFournisseur.getNom());
        assertEquals("string", savedFournisseur.getPrenom());

        // Verify Adresse
        assertNotNull(savedFournisseur.getAdresse());
        assertEquals("string", savedFournisseur.getAdresse().getAdresse1());
        assertEquals("string", savedFournisseur.getAdresse().getAdresse2());
        assertEquals("string", savedFournisseur.getAdresse().getVille());
        assertEquals("string", savedFournisseur.getAdresse().getCodePostale());
        assertEquals("string", savedFournisseur.getAdresse().getPays());
    }

    @Test
    public void testFindById() {
        // Mocking data
        AdresseDto adresseDto = AdresseDto.builder()
                .adresse1("TestAdresse1")
                .adresse2("TestAdresse2")
                .ville("TestVille")
                .codePostale("TestCodePostale")
                .pays("TestPays")
                .build();

        FournisseurDto fournisseurDto = FournisseurDto.builder()
                .nom("TestFournisseur")
                .prenom("TestPrenom")
                .adresse(adresseDto)
                .photo("TestPhoto")
                .mail("TestMail")
                .numTel("TestNumTel")
                .idEntreprise(0)
                .build();

        FournisseurDto savedFournisseur = fournisseurService.save(fournisseurDto);
        Integer fournisseurId = savedFournisseur.getId();

        // Test
        FournisseurDto foundFournisseur = fournisseurService.findById(fournisseurId);

        // Verify
        assertNotNull(foundFournisseur);
        assertEquals(fournisseurId, foundFournisseur.getId());
        assertEquals("TestFournisseur", foundFournisseur.getNom());
        assertEquals("TestPrenom", foundFournisseur.getPrenom());

        // Verify Adresse
        assertNotNull(foundFournisseur.getAdresse());
        assertEquals("TestAdresse1", foundFournisseur.getAdresse().getAdresse1());
        assertEquals("TestAdresse2", foundFournisseur.getAdresse().getAdresse2());
        assertEquals("TestVille", foundFournisseur.getAdresse().getVille());
        assertEquals("TestCodePostale", foundFournisseur.getAdresse().getCodePostale());
        assertEquals("TestPays", foundFournisseur.getAdresse().getPays());
    }

    @Test
    public void testFindAll() {
        // Test
        List<FournisseurDto> fournisseurs = fournisseurService.findAll();
        assertNotNull(fournisseurs);
        assertFalse(fournisseurs.isEmpty());
    }



}