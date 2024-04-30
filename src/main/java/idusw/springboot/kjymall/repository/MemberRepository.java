package idusw.springboot.kjymall.repository;

import idusw.springboot.kjymall.entitiy.MemberEntitiy;
import idusw.springboot.kjymall.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends
        JpaRepository<MemberEntitiy, Long> {
    Optional<Member> findByIdAndPw(String id, String pw);
//        QuerydslPredicateExecutor<MemberEntitiy> {

//    @Query("select m from MemberEntitiy m where m.id = :id and m.pw = :pw")
//    Object getMemberEntitiyById(@Param("id") String id, @Param("pw") String pw);

}
