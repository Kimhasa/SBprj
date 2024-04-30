package idusw.springboot.kjymall.service;

import idusw.springboot.kjymall.entitiy.MemberEntitiy;
import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MemberServiceTests {
    // field DI
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void loginMember(){
        Optional<Member> memberOptional  = memberRepository.findByIdAndPw("dream", "cometrue");
        if(memberOptional.isPresent())
            System.out.println("로그인 성공");
        else
            System.out.println("로그인 실패");
    }

    @Test
    public void registerMember(){
        MemberEntitiy entity = MemberEntitiy.builder()
                .id("dream")
                .pw("cometrue")
                .name("comso")
                .email("comso@induk.ac.kr")
                .build();
        if(memberRepository.save(entity) != null)
            System.out.println("등록 성공");
        else
            System.out.println("등록 실패");
    }
}
