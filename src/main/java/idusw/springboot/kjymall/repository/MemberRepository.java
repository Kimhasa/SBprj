package idusw.springboot.kjymall.repository;

import idusw.springboot.kjymall.entitiy.MemberEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends
        JpaRepository<MemberEntitiy, Long> {
//        QuerydslPredicateExecutor<MemberEntitiy> {

//    @Query("select m from MemberEntitiy m where m.id = :id and m.pw = :pw")
//    Object getMemberEntitiyById(@Param("id") String id, @Param("pw") String pw);

}
