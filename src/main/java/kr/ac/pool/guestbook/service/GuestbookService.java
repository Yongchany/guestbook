package kr.ac.pool.guestbook.service;

import com.querydsl.core.BooleanBuilder;
import kr.ac.pool.guestbook.dto.GuestbookDTO;
import kr.ac.pool.guestbook.dto.PageRequestDTO;
import kr.ac.pool.guestbook.dto.PageResultDTO;
import kr.ac.pool.guestbook.entity.GuestBook;

public interface GuestbookService {
    Long register(GuestBook dto);
    PageResultDTO<GuestbookDTO, GuestBook> getList(PageRequestDTO requestDTO);
    GuestbookDTO read(Long gno);

    void modify(GuestbookDTO dto);
    void remove(Long gno);
    BooleanBuilder getSearch(PageRequestDTO requestDTO);

    default GuestBook dtoToEntity(GuestbookDTO dto){
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(GuestBook entity){

        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
}