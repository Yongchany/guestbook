package kr.ac.pool.guestbook.controller.repository;

import kr.ac.pool.guestbook.entity.GuestBook;
import kr.ac.pool.guestbook.repository.GuestBookRepositoty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class GuestBookRepositoryTests {
    @Autowired
    private GuestBookRepositoty guestBookRepositoty;

    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1, 300).forEach(i -> {

            GuestBook guestBook = GuestBook.builder()
                    .title("Title....." + i)
                    .content("Content....." +i)
                    .writer("user" + (i % 10))
                    .build();
            System.out.println(guestBookRepositoty.save(guestBook));
        });
    }
}
