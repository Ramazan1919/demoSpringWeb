package com.sarisoku.sumus.api;

import com.sarisoku.sumus.domain.Author;
import com.sarisoku.sumus.dto.AuthorDto;
import com.sarisoku.sumus.dto.BaseApiResponse;
import com.sarisoku.sumus.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SarisokuController {


    private final AuthorService authorService;

    public SarisokuController(AuthorService authorService) {//Constructor
        this.authorService = authorService;
    }

    @GetMapping("/getAuthor")
    public ResponseEntity<BaseApiResponse<List<Author>>> getAuthorList( ){

        AuthorDto authorDto=new AuthorDto();

        List<Author> authors = authorService.getAuthorList();

        BaseApiResponse<List<Author>> response =
                BaseApiResponse.ok(authors, "Authors fetched successfully");


        return ResponseEntity.ok(response);

    }

    @GetMapping("/getAuthorById")
    public ResponseEntity<BaseApiResponse<List<Author>>> getAuthorbyId(Long Id){

        AuthorDto authorDto=new AuthorDto();

        List<Author> authors = authorService.getAuthorList();
        BaseApiResponse<List<Author>> response =
                BaseApiResponse.ok(authors, "Authors fetched successfully");


        return ResponseEntity.ok(response);

    }


}
