package com.example.stockspring.controller.api;

import com.example.stockspring.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.stockspring.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/clients")
public interface ClientApi {

    @Operation(
            summary = "Create a new client",
            description = "Create a new client with the provided details."
    )
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);

    @Operation(
            summary = "Find client by ID",
            description = "Retrieve a client by its unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found successfully."),
            @ApiResponse(responseCode = "404", description = "Client not found.")
    })
    @GetMapping(value = "/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(
            @Parameter(description = "ID of the client to be obtained", required = true)
            @PathVariable("idClient") Integer id
    );

    @Operation(
            summary = "Get all clients",
            description = "Retrieve a list of all clients."
    )
    @ApiResponse(responseCode = "200", description = "List of clients retrieved successfully.")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @Operation(
            summary = "Delete client by ID",
            description = "Delete a client by its unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Client deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Client not found.")
    })
    @DeleteMapping(value = "/delete/{idClient}")
    void delete(
            @Parameter(description = "ID of the client to be deleted", required = true)
            @PathVariable("idClient") Integer id
    );
}
