package kr.ac.pool.guestbook.controller.service;

import kr.ac.pool.guestbook.dto.GuestbookDTO;
import kr.ac.pool.guestbook.service.GuestbookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GuestBookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister(){
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Conent...")
                .writer("userSample")
                .build();

        System.out.println(service.register(guestbookDTO));
    }
}
