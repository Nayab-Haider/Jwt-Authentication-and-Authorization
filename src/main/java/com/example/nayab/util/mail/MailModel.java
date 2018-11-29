package com.example.nayab.util.mail;

import lombok.Data;

@Data
public class MailModel {

    private String to;
    private String[] multipleTo;
    private String from;
    private String subject;
    private String[] cc;
    private String[] bcc;
    private String message;

    public MailModel() {
    }

    public MailModel(String to, String from, String subject, String message) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.message = message;
    }

    public MailModel(String to, String from, String subject, String[] cc, String[] bcc, String message) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.cc = cc;
        this.bcc = bcc;
        this.message = message;
    }

    public MailModel(String[] multipleTo, String from, String subject, String[] cc, String[] bcc, String message) {
        this.multipleTo = multipleTo;
        this.from = from;
        this.subject = subject;
        this.cc = cc;
        this.bcc = bcc;
        this.message = message;
    }
}
