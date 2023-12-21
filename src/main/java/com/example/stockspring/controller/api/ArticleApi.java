package com.example.stockspring.controller.api;

import com.example.stockspring.dto.ArticleDto;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.stockspring.utils.Constants.APP_ROOT;
//@Api(APP_ROOT + "/articles")
@RequestMapping(APP_ROOT + "/articles")
public interface ArticleApi {

    @Operation(
            summary = "Create a new article",
            description = "Create a new article with the provided details."
    )
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    @Operation(
            summary = "Find article by ID",
            description = "Retrieve an article by its unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article found successfully."),
            @ApiResponse(responseCode = "404", description = "Article not found.")
    })
    @GetMapping(value = "/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(
            @Parameter(description = "ID of the article to be obtained", required = true)
            @PathVariable("idArticle") Integer id
    );

    @Operation(
            summary = "Find article by code",
            description = "Retrieve an article by its unique code."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article found successfully."),
            @ApiResponse(responseCode = "404", description = "Article not found.")
    })
    @GetMapping(value = "/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(
            @Parameter(description = "Code of the article to be obtained", required = true)
            @PathVariable("codeArticle") String codeArticle
    );

    @Operation(
            summary = "Get all articles",
            description = "Retrieve a list of all articles."
    )
    @ApiResponse(responseCode = "200", description = "List of articles retrieved successfully.")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @Operation(
            summary = "Delete article by ID",
            description = "Delete an article by its unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Article deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Article not found.")
    })
    @DeleteMapping(value = "/delete/{idArticle}")
    void delete(
            @Parameter(description = "ID of the article to be deleted", required = true)
            @PathVariable("idArticle") Integer id
    );
}