package kr.ac.pool.guestbook.repository;

import kr.ac.pool.guestbook.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepositoty extends JpaRepository<GuestBook, Long> {

}
