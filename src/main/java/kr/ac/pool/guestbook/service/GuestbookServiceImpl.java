package kr.ac.pool.guestbook.service;


import kr.ac.pool.guestbook.dto.GuestbookDTO;
import kr.ac.pool.guestbook.entity.GuestBook;
import kr.ac.pool.guestbook.repository.GuestBookRepositoty;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{

    private final GuestBookRepositoty repositoty;
    @Override
    public Long register(GuestbookDTO dto) {
        GuestBook entity = dtoToEntity(dto);
        log.info(entity);
        repositoty.save(entity);

        return entity.getGno();
    }
}
