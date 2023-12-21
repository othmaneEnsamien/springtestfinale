package com.example.stockspring.controller.api;

import com.example.stockspring.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.stockspring.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/categories")
public interface CategoryApi {

    @Operation(
            summary = "Create a new category",
            description = "Create a new category with the provided details."
    )
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto dto);

    @Operation(
            summary = "Find category by ID",
            description = "Retrieve a category by its unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found successfully."),
            @ApiResponse(responseCode = "404", description = "Category not found.")
    })
    @GetMapping(value = "/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(
            @Parameter(description = "ID of the category to be obtained", required = true)
            @PathVariable("idCategory") Integer id
    );

    @Operation(
            summary = "Find category by code",
            description = "Retrieve a category by its unique code."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found successfully."),
            @ApiResponse(responseCode = "404", description = "Category not found.")
    })
    @GetMapping(value = "/filter/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(
            @Parameter(description = "Code of the category to be obtained", required = true)
            @PathVariable("codeCategory") String codeCategory
    );

    @Operation(
            summary = "Get all categories",
            description = "Retrieve a list of all categories."
    )
    @ApiResponse(responseCode = "200", description = "List of categories retrieved successfully.")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @Operation(
            summary = "Delete category by ID",
            description = "Delete a category by its unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Category deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Category not found.")
    })
    @DeleteMapping(value = "/delete/{idCategory}")
    String delete(
            @Parameter(description = "ID of the category to be deleted", required = true)
            @PathVariable("idCategory") Integer id
    );
}
