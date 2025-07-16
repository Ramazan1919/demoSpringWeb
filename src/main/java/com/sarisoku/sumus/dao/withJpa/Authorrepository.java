package com.sarisoku.sumus.dao.withJpa;

import com.sarisoku.sumus.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Authorrepository extends JpaRepository<Author,Long> {

    @Query(value = "Select * from Author ",nativeQuery = true)
    List<Author> getAuthorList();
}
