package idusw.springboot.kjymall.repository;

import idusw.springboot.kjymall.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Override
    public int insert(Member member) {
        return 0;
    }

    @Override
    public Member read(Member member) {
        return null;
    }

    @Override
    public List<Member> selectList() {
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
}
