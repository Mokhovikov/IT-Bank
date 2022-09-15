package com.example.demo.Controllers;

import com.example.demo.Models.Card;
import com.example.demo.Models.Member;
import com.example.demo.Repository.CardRepository;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class WalletController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/accountPayment")
    public String accountPayment(@RequestParam String byn, @RequestParam String account, Model model, HttpSession session ){

        String email = (String) session.getAttribute("email");
        System.out.println("Email was written for payment " + email);
        Optional<Member> member = memberRepository.findByEmail(email);

        model.addAttribute("member", member);


        Card card = cardRepository.findByAccount(account).get();
        card.setBalance(String.valueOf(Integer.parseInt(card.getBalance())-Integer.parseInt(byn)));
        String b = card.getBalance();
        System.out.println("Send: " + b);


        card = cardRepository.findByAccount(account).get();
        card.setBalance(String.valueOf(Integer.parseInt(card.getBalance())+ Integer.parseInt(byn)));
        System.out.println("Recieved: " + card.getBalance());
        return "redirect:/PersonalAccount/MyWallet";

    }


}
