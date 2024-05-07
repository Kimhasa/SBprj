package idusw.springboot.kjymall.service;

import idusw.springboot.kjymall.entity.MemberEntity;
import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.repository.MemberJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

// Spring Boot 테스트 애플리케이션
@SpringBootTest
public class MemberServiceTests {
    // field DI (Dependency Injection): 인터페이스로부터 생성된 구현체를 주입
    @Autowired
    MemberJpaRepository memberJpaRepository; // JpaRepository 인터페이스 구현체를 참조

    @Test
    public void testMemberRegister() {
        MemberEntity entity = MemberEntity.builder()
                .id("holycow")
                .pw("cometrue")
                .name("comso")
                .email("comso@induk.ac.kr")
                .build();
        if(memberJpaRepository.save(entity) != null)
            System.out.println("register success");
        else
            System.out.println("register fail");
    }

    @Test
    public void testMemberLogin() {
        MemberEntity entity = MemberEntity.builder()
                .id("holycow")
                .pw("cometrue")
                .build();
        Optional<MemberEntity> memberEntityOptional =
                memberJpaRepository.findByIdAndPw(entity.getId(), entity.getPw());
        if(memberEntityOptional.isPresent())
            System.out.println("register success : " + memberEntityOptional.get().getId());
        else
            System.out.println("register fail");
    }
    @Test
    public void testMemberList() {
        List<MemberEntity> memberEntityList = memberJpaRepository.findAll();

        for(MemberEntity me : memberEntityList)
            System.out.println(me.getIdx() + ":" + me.getId() + ":" + me.getEmail());
    }
    @Test
    public void testMemberReadByIdx() {
        Optional<MemberEntity> memberEntityOptional = memberJpaRepository.findById(1L);

        if(memberEntityOptional.isPresent())
            System.out.println(memberEntityOptional.get().getIdx()
                    + ":" + memberEntityOptional.get().getId()
                    + ":" + memberEntityOptional.get().getEmail());
    }
}
