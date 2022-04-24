package com.example.join.basic.form;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberLoginForm {

    private String memberId;
    private String password;

    public MemberLoginForm() {
    }
}
