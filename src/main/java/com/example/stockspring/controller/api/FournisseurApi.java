package com.example.stockspring.controller.api;

import com.example.stockspring.dto.FournisseurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.stockspring.utils.Constants.APP_ROOT;
import static com.example.stockspring.utils.Constants.FOURNISSEUR_ENDPOINT;
@RequestMapping(APP_ROOT + "/fournisseurs")
public interface FournisseurApi {

    @PostMapping(FOURNISSEUR_ENDPOINT + "/create")
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/{idFournisseur}")
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/all")
    List<FournisseurDto> findAll();

    @DeleteMapping(FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);

}
