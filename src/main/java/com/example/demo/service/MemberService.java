package com.example.demo.service;


import com.example.demo.dto.CreateMemberRequest;
import com.example.demo.dto.GetMemberResponse;
import com.example.demo.dto.UpdateMemberResponse;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 id 입니다."));

    }


    // 멤버 정보 조회
    public GetMemberResponse getMember(Long id) {
        Member member = findById(id);
        return new GetMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti(),
                member.getProfileImageUrl()

        );
    }


    @Transactional
    public UpdateMemberResponse updateInfo(Long id, UpdateMemberResponse request) {
        Member member = findById(id);


        if(! member.getId().equals(request.getId())) {
            throw new IllegalStateException("존재하지 않는 id입니다");
        }

        member.updateInfo(request.getName(),request.getAge(),request.getMbti());

        return new UpdateMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }

    @Transactional
    public Long saveMember(CreateMemberRequest request) {
        Member member = new Member(request.getName(), request.getAge(), request.getMbti());
        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }

    @Transactional
    public void updateProfileImage(Long id, String key) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 멤버를 찾을수 없습니다."));
        member.updateProfileImageUrl(key);
    }


}
