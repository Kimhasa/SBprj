package idusw.springboot.kjymall.service;

import idusw.springboot.kjymall.model.Member;
import idusw.springboot.kjymall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;


    @Override
    public void create(Member member) {

    }

    @Override
    public Member readById(Long idx) {
        return null;
    }

    @Override
    public List<Member> readAll() {
        return null;
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(Member member) {

    }

    @Override
    public Member loginById(Member member) {
        memberRepository.findById(member.getIdx());
        return null;
    }
}
