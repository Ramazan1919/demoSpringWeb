package com.sarisoku.sumus.service;

import com.sarisoku.sumus.dao.withJpa.Authorrepository;
import com.sarisoku.sumus.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final  Authorrepository authorrepository;

    public AuthorServiceImpl(Authorrepository authorrepository) {
        this.authorrepository = authorrepository;
    }


    @Override
    public List<Author> getAuthorList() {



        return authorrepository.getAuthorList();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorrepository.findById(id);
    }

    @Override
    public void deleteAuthor(Long id) {
         authorrepository.deleteById(id);
    }



}
