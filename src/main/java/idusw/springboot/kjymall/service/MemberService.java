package idusw.springboot.kjymall.service;

import idusw.springboot.kjymall.entitiy.MemberEntitiy;
import idusw.springboot.kjymall.model.Member;

import java.util.List;

public interface MemberService {
    // 데이터 기본 연산 : C.R.U.D
    int create(Member member);
    Member readById(Long idx);
    List<Member> readAll();
    int update(Member member);
    int delete(Member member);

    // 사용자 정의 연산 : custom methods
    Member loginById(Member member); // id // pw

    default MemberEntitiy dtoToEntitiy(Member member){
        MemberEntitiy entitiy = MemberEntitiy.builder()
                .idx(member.getIdx())
                .id(member.getId())
                .pw(member.getPw())
                .name(member.getName())
                .email(member.getEmail())
                .build();

        return entitiy;
    }

    default Member entitiyToDto(Member entitiy){
        Member member = Member.builder()
                .idx(entitiy.getIdx())
                .id(entitiy.getId())
                .pw(entitiy.getPw())
                .name(entitiy.getName())
                .email(entitiy.getEmail())
                .build();

        return member;
    }

    Member readByIdx(Long idx);
}
