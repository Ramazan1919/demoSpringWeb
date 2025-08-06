package com.sarisoku.sumus.service;

import com.sarisoku.sumus.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
      List<Author> getAuthorList();
      Optional<Author> findById(Long id);
      void deleteAuthor(Long id);
      Author saveAuthor(Author author);
}
