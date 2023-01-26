package shop.mtcoding.test1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.test1.model.Board;
import shop.mtcoding.test1.model.BoardRepository;
import shop.mtcoding.test1.model.User;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/list")
    public String list(Model model) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/login";
        }
        List<Board> boardList = boardRepository.findByUserId(principal.getId());
        model.addAttribute("boardList", boardList);
        return "board/list";

    }
}
