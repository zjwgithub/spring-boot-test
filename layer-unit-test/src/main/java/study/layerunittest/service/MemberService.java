package study.layerunittest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.layerunittest.domain.Member;
import study.layerunittest.repository.MemberJpaRepository;
import study.layerunittest.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
//    private final MemberJpaRepository memberRepository;

    @Transactional
    public Long save(Member member) {
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }
    
    public List<Member> findMembers() {
        List<Member> members = memberRepository.findAll();
        return members;
    }

    public Optional<Member> findById(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        return optionalMember;
    }

    @Transactional
    public void changePassword(Long memberId, Member memberParam) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return;
        
        member.changePassword(memberParam.getPassword());
    }

    @Transactional
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Transactional
    public void deleteAll() {
        memberRepository.deleteAll();
    }
    
    @Transactional
    public void increaseAge(int addAge) {
        memberRepository.increaseAge(addAge);
    }
}
