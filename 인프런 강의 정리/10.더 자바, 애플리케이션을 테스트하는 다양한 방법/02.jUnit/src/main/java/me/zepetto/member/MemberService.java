package me.zepetto.member;

import me.zepetto.domain.Member;
import me.zepetto.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);
}
