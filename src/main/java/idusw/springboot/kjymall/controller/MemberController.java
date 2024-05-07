package idusw.springboot.kjymall.controller;

import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    // tightly-coupled, 기존 제어 : 개발자가 객체를 제어함
    // MemberService memberService = new MemberServiceImpl2();
    final MemberService memberService;
    // loosely-coupled : IoC (Inversion of Control) 제어의 역전, 프레임워크가 객체를 제어함
    // IoC : DL(Dependency lookup), DI(Dependency injection) ...
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/1")
    public String getOne() {
        memberService.read(new Member());
        return "./main/index";
    }
    @GetMapping("members/register")
    public String getRegister(Model model) {
        model.addAttribute("member", new Member());
        return "./members/register"; // main/register,html : 버튼 -> post 메소드 호출
    }
    @PostMapping("members/register")
    public String postRegister(@ModelAttribute Member member, Model model) { // 로그인 처리해서 지정된 페이지에 전달
        model.addAttribute("msg", "등록에 성공/실패하셨습니다.");
        return "./members/registerSuccess";
    }

    @GetMapping("members/login")
    public String getLogin(Model model) { // 로그인 페이지로
        //memberService.read(new Member(Model model));
        model.addAttribute("member", new Member());
        return "./members/login"; // templates/main/login.html : surffix, prefix 설정을 안한 기본 상태
    }

    @PostMapping("members/login")
    public String postLogin(@ModelAttribute Member member, Model model, HttpSession session) { // 로그인 처리해서 지정된 페이지에 전달
        String message = "로그인 실패하셨습니다.";
        Member ret = null; // DBMS에 저장된 정보를 접근하여 생성한 객체
        if((ret = memberService.login(member)) != null) {
            session.setAttribute("id", ret.getId());
            message = member.getId() + "님" + " 로그인 성공하셨습니다.";
        }
        model.addAttribute("msg", message);
        return "./members/success";
    }
    @GetMapping("members/logout")
    public String getLogout(HttpSession session) {
        session.invalidate(); // session 객체 무효화
        // return "./main/index";
        return "redirect:/"; // HomeController의 @GetMapping("/")으로 재지정
    }
}