package idusw.springboot.kjymall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping(value= {"api/v2", "api/v2/"})
    public String getRestApiV1(Model model) {
        // org.springfrmaework.ui.Model :
        // UI(User Interface, View, Template)에서 사용하는 Model 클래스
        // model을 활용해서 view에게 속성을 전달
        model.addAttribute("name", "박승민"); // model 객체에 속성을 추가(지정)
        model.addAttribute("dept", "컴퓨터 소프트웨어학과");

        // view or template 파일을 지정해주어야 한다.
        return "./main/index"; // templates 아래 index.html을 접근 (기본 dynamic wep page)
    }
    @GetMapping(value={"400"})
    public String go400(Model model) {
        model.addAttribute("msg", "정보 전달");
        return "./error/400"; // view에게 전달
    }
    @GetMapping(value={"", "/"})
    public String goHome(Model model) {
        model.addAttribute("msg", "정보 전달");
        return "./main/index"; // index.html에게 전달
    }
}
