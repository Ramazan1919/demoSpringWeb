package com.sarisoku.sumus.dao.withJpa;

import com.sarisoku.sumus.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
