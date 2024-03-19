package idusw.springboot.kjymall.controller;

import idusw.springboot.kjymall.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/1"}) // Get Method 요청으로 처리하라는 annotation
    public String getRoot(){
        // model : dto (data transfer object)
        // -- model --> service --> model --> repository -> service -> controller -> view
        return "main/index"; //view
    }

    @GetMapping("/2")
    public String getIndex2(Model model){
        Member member = new Member();
        member.setId("kjy");
        member.setName("김진영");
        member.setEmail("kjy@induk.ac.kr");
        
        // spring에서 ui 통해 view에게 전달할 때 사용하는 객체 : Model model
        model.addAttribute("member", member);
        model.addAttribute("name", "김진영");
        model.addAttribute("attr","model객체의 속성값");
        model.addAttribute("name","김진영");
        return "main/index2";
    }
}
