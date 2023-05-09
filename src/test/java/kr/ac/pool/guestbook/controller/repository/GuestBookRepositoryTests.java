package kr.ac.pool.guestbook.controller.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import kr.ac.pool.guestbook.entity.GuestBook;
import kr.ac.pool.guestbook.entity.QGuestBook;
import kr.ac.pool.guestbook.repository.GuestBookRepositoty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestBookRepositoryTests {
    @Autowired
    private GuestBookRepositoty guestBookRepositoty;

    @Test
    public void testQuery1(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
        QGuestBook qGuestBook = QGuestBook.guestBook;
        String keyword = "7";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression = qGuestBook.title.contains(keyword);
        builder.and(expression);
        Page<GuestBook> result = guestBookRepositoty.findAll(builder, pageable);
        result.stream().forEach(guestBook -> {
            System.out.println(guestBook);
        });
    }
    @Test
    public void testQuery2() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
        QGuestBook qGuestBook = QGuestBook.guestBook;
        String keyword = "7";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expTitle = qGuestBook.title.contains(keyword);
        BooleanExpression expWriter = qGuestBook.writer.contains(keyword);
        BooleanExpression expAll = expTitle.or(expWriter);
        builder.and(expAll);
        builder.and(qGuestBook.gno.gt(50L));
        Page<GuestBook> result = guestBookRepositoty.findAll(builder, pageable);
        result.stream().forEach(guestBook -> {
            System.out.println(guestBook);
        });
    }



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

    @Test
    public void updateTest(){
        Optional<GuestBook> result = guestBookRepositoty.findById(300L);

        if(result.isPresent()){
            GuestBook guestBook = result.get();
            guestBook.changeTitle("Changed Title...");
            guestBook.changeContent("Changed Content...");
            guestBookRepositoty.save(guestBook);
        }

    }
}
