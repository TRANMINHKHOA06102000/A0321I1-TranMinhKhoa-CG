package com.codegym.repository;

import com.codegym.model.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> showAll();
    void addEmail(Email email);
    List<String> listLanguage();
    List<Integer> listPage();
}
