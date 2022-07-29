package com.example.demo.Controllers;

import com.example.demo.Models.Member;
import com.example.demo.Models.MemberService;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PersonalPageControllers {




    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/PersonalAccount")
    public String personalAccount(
            Model model,
            HttpSession session){

        String email = (String) session.getAttribute("email");
        System.out.println(email);
        Optional<Member> member = memberRepository.findByEmail(email);
        ArrayList<Member> members = new ArrayList<>();
        member.ifPresent(members::add);

        model.addAttribute("members", members);


        return "PersonalPage/PersonalPage";
    }



    @GetMapping("/PersonalAccount/MyWallet")
    public String myWallet(){
        return "PersonalPage/MenuPersonalPage/MyWallet/MyWallet";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/home";
    }

    @GetMapping("/403")
    public String error(){
        return "403";
    }

}
