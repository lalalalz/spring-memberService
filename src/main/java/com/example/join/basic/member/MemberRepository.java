package com.example.join.basic.member;

import com.example.join.basic.form.MemberForm;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class MemberRepository {

    private static Map<String, Member> store = new LinkedHashMap<>();

    public Member save(Member member) {
        store.put(member.getMemberId(), member);
        return member;
    }

    public Member findById(String memberId) {
        Member member = store.get(memberId);
        return member;
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(String memberId, MemberForm memberForm) {
        Member findMember = store.get(memberId);
        findMember.setMemberName(memberForm.getMemberName());
        findMember.setAge(memberForm.getAge());
        findMember.setEmail(memberForm.getEmail());
        findMember.setAuthority(memberForm.getAuthority());
        findMember.setFarms(memberForm.getFarms());
    }

    public void clear() {
        store.clear();
    }

    @PostConstruct
    public void init() {
        save(new Member("lalalalz", "1234", "진수", 29, "lalalalz@naver.com", new Integer[]{1,2,3,4}, MemberAuthority.ADMIN));
        save(new Member("mkjs0309", "5768", "민경", 19, "mkjs0309@gmail.com", new Integer[]{1,2,3,4}, MemberAuthority.USER));
    }
}
