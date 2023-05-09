package kr.ac.pool.guestbook.service;

import kr.ac.pool.guestbook.dto.GuestbookDTO;
import kr.ac.pool.guestbook.entity.GuestBook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);

    default GuestBook dtoToEntity(GuestbookDTO dto){
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }
}
