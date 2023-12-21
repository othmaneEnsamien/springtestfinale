package com.example.stockspring.controller.api;

import com.example.stockspring.dto.ChangerMotDePasseUtilisateurDto;
import com.example.stockspring.dto.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.stockspring.utils.Constants.APP_ROOT;
import static com.example.stockspring.utils.Constants.UTILISATEUR_ENDPOINT;
@RequestMapping(APP_ROOT + "/utilisateurs")
public interface UtilisateurApi {

    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
    UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);

}
