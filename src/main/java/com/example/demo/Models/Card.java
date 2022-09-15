package com.example.demo.Models;


import org.iban4j.Iban;

import javax.persistence.*;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String email;

    @Column
    private String number;

    @Column
    private String expireData;

    @Column
    private String cardHolder;

    @Column
    private String cvc;

    @Column
    private String image;

    @Column
    private String account;

    @Column
    private String balance;

    public Card(String email, String number, String expireData, String cardHolder, String cvc, Iban account) {
        this.email = email;
        this.number = number;
        this.expireData = expireData;
        this.cardHolder = cardHolder;
        this.cvc = cvc;
        this.account = String.valueOf(account);
    }



    public Card() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpireData() {
        return expireData;
    }

    public void setExpireData(String expireData) {
        this.expireData = expireData;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
