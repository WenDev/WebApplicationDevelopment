package site.wendev.qikebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import site.wendev.qikebao.entities.User;
import site.wendev.qikebao.service.UserService;
import site.wendev.qikebao.vo.LoginVO;

import javax.servlet.http.HttpSession;

/**
 * 登录的Controller
 *
 * @author 江文
 * @since 2020/11/18 7:08 下午
 */
@Validated
@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(LoginVO loginVO, RedirectAttributes attributes) {
        User user = userService.login(loginVO.getUsername(), loginVO.getPassword());
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/workbench";
        } else {
            attributes.addFlashAttribute("errInfo", "登录失败：用户名或密码不正确");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/login";
    }
}
