package com.example.stockspring.controller.api;

import com.example.stockspring.dto.EntrepriseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.stockspring.utils.Constants.APP_ROOT;
import static com.example.stockspring.utils.Constants.ENTREPRISE_ENDPOINT;
@RequestMapping(APP_ROOT + "/entreprises")
public interface EntrepriseApi {

    @PostMapping(ENTREPRISE_ENDPOINT + "/create")
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(ENTREPRISE_ENDPOINT + "/{idEntreprise}")
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(ENTREPRISE_ENDPOINT + "/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping(ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);

}