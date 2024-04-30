package idusw.springboot.kjymall.controller;

import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    final MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("members/{id}")
    public String getById(@PathVariable("id") String id, Model model){
//        Member member = new Member();
        Member member = Member.builder().build();
        member.setId(id);

        model.addAttribute("member", member);
        return "./main/index";
    }

    // get방식으로 members/login을 요청하면 main/login 페이지로 이동
    @GetMapping("members/login")
    public String getLogin(Model model){
        model.addAttribute("member", Member.builder().build());
        return "./main/login";
    }

    // main/login.html 에서 폼을 통해 post 요청, 처리 후 main/index.html로 이동
    @PostMapping("login")
    public String postLogin(@ModelAttribute("member") Member member, Model model, HttpSession session){
        String id = member.getId();
        String pw = member.getPw();

        Member m = Member.builder()
                .id(id)
                .pw(pw)
                .build();
        String msg = "";

        Member ret = memberService.loginById(m);

        String dbId = ret.getId();
        String dbPw = ret.getPw();

        if(id.equals(dbId) && pw.equals(dbPw)){
            session.setAttribute("id", id);
            msg = "로그인 성공";
        }
        else{
            msg = "로그인 실패";
        }

        model.addAttribute("message", msg);
        return "./main/400";
    }

    @GetMapping("/members/logout")
    public String getLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    // main/login.html 에서 폼을 통해 post 요청, 처리 후 main/index.html로 이동
    @PutMapping("update")
    public String postRegister(@ModelAttribute("member") Member member, Model model, HttpSession session){
        // 요청 정보 객체
        String msg = "";

        // Database로 부터 정보를 가져올 예정임
        int ret = memberService.create(member);
        // memberService.loginByIdAndPw(m);
        // 사용자가 제공한 정보와 DB로 부터 가져온 정보를 처리
        if(ret > 0){
            msg = "등록 성공";
        } else{
            msg = "등록 실패";
        }

        model.addAttribute("message", msg);
        return "./main/400";
    }

    @GetMapping("/{idx}")
    public String getMember(@PathVariable("idx") Long idx, Model model){
        Member ret = memberService.readByIdx(idx);
        model.addAttribute("member", ret);
        return "./main/detail";
    }

    //업데이트 처리
    @GetMapping("update")
    public String getUpdate(Model model){
        model.addAttribute("member", Member.builder().build());
        return "./main/update";
    }

    @PutMapping("update")
    public String postUpdate(@ModelAttribute("member") Member member, Model model, HttpSession session) {
        {
            model.addAttribute("message", "성공");
            return "./main/400";
        }
    }
}
