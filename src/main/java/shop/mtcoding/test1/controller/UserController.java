package shop.mtcoding.test1.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.test1.model.User;
import shop.mtcoding.test1.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/loginForm")
    public String loginForm(HttpServletRequest request) {
        // JSESSIONID=6A5470C7B10910305F1AC87C6DAFD0AF
        String username = "";

        // ${cookie.remember.value}
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("remember")) {
                username = cookie.getValue();
            }
        }
        request.setAttribute("remember", username);
        return "user/loginForm";
    }

    // 로그인
    @PostMapping("/login")
    public String login(String username, String password, String remember, HttpServletResponse response) {

        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        }
        if (remember == null) {
            remember = "";
        }
        if (remember.equals("on")) {
            Cookie cookie = new Cookie("remember", username);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("remember", "");
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
        }
        session.setAttribute("principal", user);
        return "redirect:/";
    }

    // 회원가입 페이지
    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
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

    @GetMapping("/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @PostMapping("/update")
    public String update(int id, String password) {
        User principal = (User) session.getAttribute("prinipal");
        int result = userRepository.updateById(principal.getId(), password);
        if (result == 1) {
            return "redirect:/";
        } else {
            return "redirect:/updateForm";
        }
    }
}
