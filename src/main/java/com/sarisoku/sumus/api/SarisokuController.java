package com.sarisoku.sumus.api;

import com.sarisoku.sumus.domain.Author;
import com.sarisoku.sumus.domain.Book;
import com.sarisoku.sumus.dto.AuthorDto;
import com.sarisoku.sumus.dto.BaseApiResponse;
import com.sarisoku.sumus.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SarisokuController {


    private final AuthorService authorService;


    private final ModelMapper modelMapper;


    public SarisokuController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
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
    @PostMapping("/saveAuthor")
    public ResponseEntity<BaseApiResponse<Author>> saveAuthor(@RequestBody  AuthorDto dto){

        Author author = new Author();
        author.setName(dto.getName());
        author.setNationality(dto.getNationality());
        author.setAge(dto.getAge());

        // Kitap varsa ekle
        if (dto.getBooks() != null) {
            List<Book> books = dto.getBooks().stream().map(bookDto -> {
                Book book = new Book();
                book.setName(bookDto.getName());
                book.setIsbn(bookDto.getIsbn());
                book.setDate(bookDto.getDate());
                book.setAuthor(author); // 🔥 ilişkiyi kur
                return book;
            }).toList();
            author.setBooks(books); // yazarın kitaplarını bağla
        }

        Author author1 = authorService.saveAuthor(author);// cascade sayesinde kitaplar da kaydolur
        BaseApiResponse<Author> response =
                BaseApiResponse.ok(author1, "Authors fetched successfully");
        return ResponseEntity.ok(response);



    }




}
