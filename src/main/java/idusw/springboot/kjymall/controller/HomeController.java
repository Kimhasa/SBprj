package idusw.springboot.kjymall.controller;

import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.service.HomeService;
import idusw.springboot.kjymall.service.HomeServiceImpl3;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {

    // private HomeService homeService = new HomeServiceImpl3(); // tightly-coupled
    // @Autowired // 필드 주입 : field injection
    // setter injection

    // loosely-coupled <- IoC Container, DI
    private final HomeService homeService;
    public HomeController(HomeService homeService) {  // constructor injection
        this.homeService = homeService;
    }

    @GetMapping(value={"/", ""})
    public String goLogin() {
        return "redirect:/members/login";
    }

    // http://localhost:8080/?name=<value> : 값을 매개변수 값이 request객체에 저장됨
    @GetMapping(value={"/1"}) // Get Method 요청으로 처리하라는 annotation
    public String getRoot(HttpServletRequest request, Model model) {
        homeService.sayHello();
        // model : dto (data transfer object)
        // -- model --> service -- model --> repository -> service -> controller -> view
        model.addAttribute("greeting", request.getParameter("name"));
        return "main/index"; // view
    }

    @GetMapping("/2")
    public String getIndex2(@RequestParam Map<String, String> param, Model model){
        Member member = new Member();
        member.setId("kjy");
        member.setName(param.get("name"));
        member.setEmail(param.get("email"));
        
        // spring에서 ui 통해 view에게 전달할 때 사용하는 객체 : Model model
        model.addAttribute("member", member);
//        model.addAttribute("name", "김진영");
//        model.addAttribute("attr","model객체의 속성값");
//        model.addAttribute("name","김진영");
        return "main/index2";
    }
}
