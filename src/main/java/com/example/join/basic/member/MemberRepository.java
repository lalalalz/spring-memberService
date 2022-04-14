package com.example.join.basic.member;

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

    public void update(String memberId, Member memberParam) {
        Member findMember = store.get(memberId);
        findMember.setMemberName(memberParam.getMemberName());
        findMember.setAge(memberParam.getAge());
        findMember.setEmail(memberParam.getEmail());
    }

    public void clear() {
        store.clear();
    }

    @PostConstruct
    public void init() {
        save(new Member("lalalalz", "1234", "진수", 29, "lalalalz@naver.com"));
        save(new Member("mkjs0309", "5768", "민경", 19, "mkjs0309@gmail.com"));
    }
}
