package kr.ac.pool.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


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

    public PageRequest getPageable(Sort sort){
        return PageRequest.of(page-1, size, sort);
    }
}
