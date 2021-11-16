package com.codegym.service;

import com.codegym.model.Email;

import java.util.List;

public interface EmailService {
    List<Email> showAll();
    void addEmail(Email email);
    List<String> listLanguage();
    List<Integer> listPage();
}
