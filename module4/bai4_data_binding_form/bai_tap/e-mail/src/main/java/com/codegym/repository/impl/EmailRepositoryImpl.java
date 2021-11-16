package com.codegym.repository.impl;

import com.codegym.model.Email;
import com.codegym.repository.EmailRepository;

import java.util.ArrayList;
import java.util.List;

public class EmailRepositoryImpl implements EmailRepository {
    static List<Email> emailList = new ArrayList<>();
    static List<String> languages = new ArrayList<>();

    static List<Integer> pageList = new ArrayList<>();

    static {
        emailList.add(new Email("VietNamese", 25, true, "Iron man from Earth"));
        emailList.add(new Email("English", 25, true, "Iron man from Earth"));
        emailList.add(new Email("Chinese", 25, true, "Iron man from Earth"));
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Chinese");
        languages.add("Japanese");
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
    }

    @Override
    public List<Email> showAll() {
        return emailList;
    }

    @Override
    public void addEmail(Email email) {
        emailList.add(email);
    }

    @Override
    public List<String> listLanguage() {
        return languages;
    }

    @Override
    public List<Integer> listPage() {
        return pageList;
    }
}
