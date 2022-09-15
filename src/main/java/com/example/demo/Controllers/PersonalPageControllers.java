package com.example.demo.Controllers;

import com.example.demo.Models.Card;
import com.example.demo.Models.Member;
import com.example.demo.Models.MemberServiceImpl;
import com.example.demo.Repository.CardRepository;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PersonalPageControllers {

    @Autowired
    private CardRepository cardRepository;

    private final MemberServiceImpl memberService;

    public PersonalPageControllers(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/PersonalAccount")
    public String personalAccount(
            Model model,
            HttpSession session,
            String email){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        email = auth.getName();
        System.out.println("Personal Account: " + email);
       memberService.memberOutSession(email,session,model);



        return "PersonalPage/PersonalPage";
    }

    @PostMapping("/Personal")
    public String loginMember(
            @RequestParam String email,
            HttpSession session
    ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        email = auth.getName();
        System.out.println("Personal " + email);
      memberService.memberInSession(email,session);
        return "redirect:/PersonalAccount";
    }



    @GetMapping("/PersonalAccount/MyWallet")
    public String myWallet(
        Model model,
        HttpSession session,
        String email){

            memberService.showCards(email,session,model);
        System.out.println(email);
        return "PersonalPage/MenuPersonalPage/MyWallet/MyWallet";
    }



    @GetMapping("/PersonalAccount/MyWallet/add")
    public String addCard(
            Model model,
            HttpSession session,
            String email){

        model.addAttribute("card", new Card());
        return "PersonalPage/MenuPersonalPage/MyWallet/addCard";
    }

    @PostMapping("/add")
    public String add(
            Model model, HttpSession session,
            @RequestParam String number, @RequestParam String card_holder,
            @RequestParam String expire_data, @RequestParam String cvc){

        String email = (String) session.getAttribute("email");
        System.out.println("Email was written for card " + email);

        System.out.println("Card number: " + number);
        System.out.println("Expire date: " + expire_data);
        System.out.println("Card holder: " + card_holder);
        System.out.println("Card cvc: " + cvc);

        String expireDateSave = expire_data.substring(0,2) + "/" + expire_data.substring(2,4);
        String numberSave = number.substring(0,4) + " **** **** " + number.substring(12,16);

        Iban account = new Iban.Builder()
                .countryCode(CountryCode.BY)
                .buildRandom();

        Card card = new Card(email, numberSave, expireDateSave,card_holder,cvc, account);
        card.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ49Y4JHWIsDbLL4e_U65fBCeWE3VCVIzjqfw&usqp=CAU");

        memberService.addCard(card, email,session);


        return "redirect:/PersonalAccount/MyWallet";
    }

    @GetMapping("/logoutPage")
    public String logout(HttpSession session){
        System.out.println("Logout");
        return "redirect:/home";
    }

    @GetMapping("/403")
    public String error(){
        return "403";
    }

}
