package shop.mtcoding.test1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.test1.model.Board;
import shop.mtcoding.test1.model.BoardRepository;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping({ "/", "/board" })
    public String home(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id, Model model) {
        Board board = boardRepository.findById(id);
        if (board == null) {
            return "redirect:/notfound";
        } else {
            model.addAttribute("board", board);
            return "board/detail";
        }
    }
}
