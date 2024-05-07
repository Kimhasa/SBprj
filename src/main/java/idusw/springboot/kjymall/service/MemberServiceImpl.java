package idusw.springboot.kjymall.service;

import idusw.springboot.kjymall.entity.MemberEntity;
import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.repository.MemberJpaRepository;
import idusw.springboot.kjymall.repository.MemberRepository;
import idusw.springboot.kjymall.repository.MemberRepositoryImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    /*
    final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자: 주입된 객체 필드에 배정
        this.memberRepository = memberRepository;
    }
     */

    final MemberJpaRepository memberJpaRepository;
    public MemberServiceImpl(MemberJpaRepository MemberJpaRepository) { // 생성자: 주입된 객체 필드에 배정
        this.memberJpaRepository = MemberJpaRepository;
    }

    @Override
    public int create(Member dto) {
        return 0;
    }

    @Override
    public Member read(Member dto) {
        System.out.println("read :: ");
        Optional<MemberEntity> result = memberJpaRepository.findById(1L);
        return null;
    }

    @Override
    public List<Member> readList() {
        return null;
    }

    @Override
    public int update(Member dto) {
        return 0;
    }

    @Override
    public int delete(Member dto) {
        return 0;
    }

    @Override
    public Member login(Member dto) {
        MemberEntity entity = dtoToEntity(dto);
        Optional<MemberEntity> memberEntityOptional =
                memberJpaRepository.findByIdAndPw(entity.getId(), entity.getPw());
        if(memberEntityOptional.isPresent())
            return entityToDto(memberEntityOptional.get());
        else
            System.out.println("register fail");
        return null;
    }
}
