package kr.ac.pool.guestbook.controller;

import kr.ac.pool.guestbook.dto.PageRequestDTO;
import kr.ac.pool.guestbook.dto.PageResultDTO;
import kr.ac.pool.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestBookController {
    private final GuestbookService service;
    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping({"/", "/list"})
    public String list(PageRequestDTO pageRequestDTO, Model model){
        log.info("페이지 요청 정보" + pageRequestDTO);
        model.addAttribute("result", service.getList(pageRequestDTO));
        return null;
    }
}
