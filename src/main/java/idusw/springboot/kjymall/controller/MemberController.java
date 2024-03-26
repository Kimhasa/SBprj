package idusw.springboot.kjymall.controller;

import idusw.springboot.kjymall.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @GetMapping("members/{id}")
    public String getById(@PathVariable("id") String id, Model model){
        Member member = new Member();
        member.setId(id);

        model.addAttribute("member", member);
        return "./main/index";
    }

    // get방식으로 members/login을 요청하면 main/login 페이지로 이동
    @GetMapping("members/login")
    public String getLogin(){

        return "./main/login";
    }

    // main/login.html 에서 폼을 통해 post 요청, 처리 후 main/index.html로 이동
    @PostMapping("members/login")
    public String postLogin(@ModelAttribute("member") Member member, Model model){
        String id = member.getId();
        String pw = member.getPw();

        Member m = new Member();
        if(id.equals("induk") && pw.equals("comso")){
            m.setId("로그인 성공");
            model.addAttribute("member", m);
        }
        else{
            m.setId("로그인 성공");
            model.addAttribute("member", m);
        }

        return "./main/index";
    }
}
