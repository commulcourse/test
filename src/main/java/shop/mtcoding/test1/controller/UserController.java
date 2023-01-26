package shop.mtcoding.test1.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.test1.model.User;
import shop.mtcoding.test1.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result == 1) {
            return "redirect:/loginForm";
        } else {
            return "redirect:/joinForm";
        }
    }

    // 회원가입 페이지
    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/updateForm")
    public String updateForm() {
        // public String updateForm(@PathVariable int id) {
        // User principal = (User) session.getAttribute("principal");
        // if (principal == null) {
        // return "redirect:/loginForm";
        // }
        // if (principal.getId() != id) {
        // return "redirect:/loginForm";
        // }
        return "user/updateForm";

    }

    @PostMapping("/update")
    public String update(String password, String email) {
        User principal = (User) session.getAttribute("principal");
        int result = userRepository.update(principal.getId(), password, email);
        if (result == 1) {
            return "redirect:/";
        } else {
            return "update";
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/loginForm";
    }

    // 로그인
    @PostMapping("/login")
    public String login(String username, String password) {

        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        }
        session.setAttribute("principal", user);
        return "redirect:/board";
    }

}
