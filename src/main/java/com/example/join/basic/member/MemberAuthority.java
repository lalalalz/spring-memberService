package com.example.join.basic.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberAuthority {
    ADMIN("admin"), USER("user");
    private final String description;
}
