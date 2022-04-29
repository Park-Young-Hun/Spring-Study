package begin.springbegin.service;

import begin.springbegin.domain.Member;
import begin.springbegin.repository.MemberRepository;
import begin.springbegin.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {
    
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        
        //같은 이름이 있는 중복 회원 x
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
