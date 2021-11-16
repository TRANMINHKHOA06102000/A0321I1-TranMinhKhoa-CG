package com.codegym.service.impl;

import com.codegym.model.Email;
import com.codegym.repository.EmailRepository;
import com.codegym.repository.impl.EmailRepositoryImpl;
import com.codegym.service.EmailService;

import java.util.List;

public class EmailServiceImpl implements EmailService {
    EmailRepository emailRepository =new EmailRepositoryImpl();
    @Override
    public List<Email> showAll() {
        return emailRepository.showAll();
    }

    @Override
    public void addEmail(Email email) {
        emailRepository.addEmail(email);
    }

    @Override
    public List<String> listLanguage() {
        return emailRepository.listLanguage();
    }

    @Override
    public List<Integer> listPage() {
        return emailRepository.listPage();
    }
}
