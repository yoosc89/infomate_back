package com.pro.infomate.member.repository;

import com.pro.infomate.member.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {



    //  @EntityGraph(attributePaths = {"department", "rank"})
  Member findByMemberId(String memberId);

  List<Member> findByMemberCodeIn(List<Integer> ids);

  Member findByMemberCode(int memberCode);
    @Query("SELECT MAX(a.memberCode) FROM Member a")
    int maxMemberCode();

//  boolean findByMemberEmail(String memberEmail);
}
