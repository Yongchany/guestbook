package kr.ac.pool.guestbook.repository;

import kr.ac.pool.guestbook.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GuestBookRepositoty extends JpaRepository<GuestBook, Long>,
        QuerydslPredicateExecutor<GuestBook> {

}