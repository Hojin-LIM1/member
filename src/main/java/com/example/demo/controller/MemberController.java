package com.example.demo.controller;


import com.example.demo.common.FileDownloadUrlResponse;
import com.example.demo.common.FileUploadResponse;
import com.example.demo.common.S3Service;
import com.example.demo.dto.CreateMemberRequest;
import com.example.demo.dto.GetMemberResponse;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    public static void main(String[] args) {

    }
    private final MemberService memberService;
    private final S3Service s3Service;

    @PostMapping
    public ResponseEntity<Long> saveMember(
            @RequestBody CreateMemberRequest request) {
                Long saveId = memberService.saveMember(request);
                return ResponseEntity.ok(saveId);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetMemberResponse> getMember(@PathVariable Long id){
        GetMemberResponse response = memberService.getMember(id);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/{id}/profile-image")
    public ResponseEntity<FileUploadResponse> upload(
            @PathVariable Long id,
            @RequestParam("profile-image") MultipartFile file) {
        String key = s3Service.upload(file);
        memberService.updateProfileImage(id,key);

        return ResponseEntity.ok(new FileUploadResponse(key));
    }

    @GetMapping("/{id}/profile-image")
    public ResponseEntity<FileDownloadUrlResponse> getDownloadUrl(@PathVariable Long id) {
        GetMemberResponse member = memberService.getMember(id);
        String key = member.getProfileImageUrl();

        URL url = s3Service.getDownloadUrl(key);

        return ResponseEntity.ok(new FileDownloadUrlResponse(url.toString()));
    }
}
