package com.energy.crm.examples;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/books")
@Tag(description = "Books rest services", name="Books")
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Operation(summary = "Get a book by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the book",   content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),  
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied",   content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Book not found",   content = @Content) })
	
	@GetMapping("/{id}")
	public Book findById(@Parameter(description = "id of book to be searched") 
	  @PathVariable long id) {
	    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
	@Operation(summary = "Get a book by its id",security = @SecurityRequirement(name = "bearer-authentication"))
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the book",   content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),  
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied",   content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Book not found",   content = @Content) })
	
	@GetMapping("/admin/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Book findByIdAdmin(@Parameter(description = "id of book to be searched") 
	  @PathVariable long id) {
	    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
	@Operation(summary = "Get a book by its id",security = @SecurityRequirement(name = "bearer-authentication"))
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the book",   content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),  
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied",   content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Book not found",   content = @Content) })
	
	@GetMapping("/user/{id}")
	@PreAuthorize("hasRole('USER')")
	public Book findByIdUser(@Parameter(description = "id of book to be searched") 
	  @PathVariable long id) {
	    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
	@Operation(summary = "Get a book by its id",security = @SecurityRequirement(name = "bearer-authentication"))
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the book",   content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),  
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied",   content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Book not found",   content = @Content) })
	
	@GetMapping("/logged/{id}")
	@PreAuthorize("isAuthenticated()")
	public Book findByIdLogged(@Parameter(description = "id of book to be searched") 
	  @PathVariable long id) {
	    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

}
