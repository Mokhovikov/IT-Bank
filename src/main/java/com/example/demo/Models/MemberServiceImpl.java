package com.example.demo.Models;



import com.example.demo.Repository.CardRepository;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private JavaMailSender emailSender;



    public void createMember(Member member) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("MEMBER");
        List<Role> roles = new ArrayList<>();
        roles.add(memberRole);
        member.setRole(roles);
        memberRepository.save(member);
    }

    @Override
    public void editMember(Member member) {

    }

    @Override
    public void memberInSession(String email, HttpSession session) {
        session.setAttribute("email", email);
        System.out.println(session.getAttribute("email"));
        System.out.println("post");

    }

    @Override
    public void memberOutSession(String email, HttpSession session, Model model) {
        session.setAttribute("email", email);
        System.out.println("Email was written for session " + email);
        Optional<Member> member = memberRepository.findByEmail(email);
        ArrayList<Member> members = new ArrayList<>();
        member.ifPresent(members::add);
        model.addAttribute("members", members);

        Iterable<Card> card = cardRepository.findAllByEmail(email);
        ArrayList<Card> card1 = new ArrayList<>();
        if (card.iterator().hasNext()) {
            card1.add(card.iterator().next());
        }

        if (card1.size() > 0) {
            model.addAttribute("card", card1.get(0));
            System.out.println("Card on screen");
        } else {
            model.addAttribute("card", new Card());
            System.out.println("Storage of card is empty!");
        }



    }

    @Override
    public void showCards(String email, HttpSession session, Model model) {
        email = (String) session.getAttribute("email");
        System.out.println("Email was written for carousel " + email);
        Optional<Member> member = memberRepository.findByEmail(email);
        ArrayList<Member> members = new ArrayList<>();
        member.ifPresent(members::add);
        model.addAttribute("members", members);


        Iterable<Card> card = cardRepository.findAllByEmail(email);
        if (!card.iterator().hasNext()) {
            model.addAttribute("Empty", "Please, add a card");
            System.out.println("Please, add a card");
        }

        model.addAttribute("AllCards", card);

    }


    @Override
    public void addCard(Card card, String email, HttpSession session) {


        cardRepository.save(card);
    }

    @Override
    public void logout(HttpSession session) {
        session.setAttribute("email", 0);
        System.out.println("Email was deleted!");
    }


    public void sendSimpleMessage(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo("kepov83700@keyido.com");
        message.setSubject("subject");
        message.setText("text");
        emailSender.send(message);

    }

}