package Spring_Boot_Study.Hello_Spring_Boot.service;

import Spring_Boot_Study.Hello_Spring_Boot.domain.Member;
import Spring_Boot_Study.Hello_Spring_Boot.repository.MemberRepository;
import Spring_Boot_Study.Hello_Spring_Boot.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // 기존의 new 로 새 객체를 생성하는 대신 constructor로 외부에서 넣어주도록 변경
    // DI(Dependency Injection) - 외부에서 넣어줌
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        // 여기서는 중복 이름 안되게 설정
        
        // "memberRepository.findByName((member.getName()));" 까지만 쓰고
        // ctrl + alt + v 하면 자동으로 할당 받는 변수 생성해줌.
//        Optional<Member> result = memberRepository.findByName((member.getName()));
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        
        // 위 표현 대신 아래처럼 하느게 이쁨.
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });

        // 위의 것을 메소드로 지정
        validateDuiplicateMember(member);
    }

    private void validateDuiplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
