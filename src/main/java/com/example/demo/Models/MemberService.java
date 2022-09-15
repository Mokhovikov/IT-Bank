package com.example.demo.Models;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemberService {

    void createMember(Member member);

 /*
 List<Member> readAll();
 */

    void editMember(Member member);


    void memberInSession(String email, HttpSession session);

    void memberOutSession(String email, HttpSession session, Model model);

    void showCards(String email, HttpSession session, Model model);

    void addCard(Card card, String email, HttpSession session);

    void logout(HttpSession session);





}
