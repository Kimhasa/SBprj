package idusw.springboot.kjymall.service;

import idusw.springboot.kjymall.entitiy.MemberEntitiy;
import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Override
    public int create(Member member) {
        // Member 객체를 활용하여서 MemberEntity 객체를
        MemberEntitiy entitiy = dtoToEntitiy(member);
        if(memberRepository.save(entitiy) != null)
            return 1;
        else
            return 0;
    }

    @Override
    public Member readById(Long idx) {
        return null;
    }

    @Override
    public Member readByIdx(Long idx) { // loginById 와 매우 흡사
        Optional<MemberEntitiy> memberOptional = memberRepository.findById(idx);
        return null;
    }

    @Override
    public List<Member> readAll() {
        return null;
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int delete(Member member) {
        return 0;
    }

    @Override
    public Member loginById(Member member) {
        //MemberRepository 메소드 호출
        Optional<Member> memberOptional  = memberRepository.findByIdAndPw(member.getId(), member.getPw());
        if(memberOptional.isPresent())
            return entitiyToDto(memberOptional.get());
        else
            return null;
    }
}
