package kr.ac.pool.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    private int page;
    private int size;

    public PageRequestDTO(){
        page = 1;
        size = 10;
    }

    public Pageable getPageable(Sort sort){
        return (Pageable) PageRequest.of(page-1, size, sort);
    }
}