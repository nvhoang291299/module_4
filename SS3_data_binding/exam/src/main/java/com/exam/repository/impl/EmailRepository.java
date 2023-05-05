package com.exam.repository.impl;

import com.exam.model.Email;
import com.exam.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static Email email1 = new Email(0,"Vietnamese",50, true, "Hello");
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> pageSizes = new ArrayList<>();

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getSizes() {
        return pageSizes;
    }

    @Override
    public Email update(Email email) {
        if (email.getId() == email1.getId()){
            email1.setId(email.getId());
            email1.setLanguage(email.getLanguage());
            email1.setPageSize(email.getPageSize());
            email1.setSpamsFilter(email.isSpamsFilter());
            email1.setSignature(email.getSignature());
        }
        return email1;
       }
}
