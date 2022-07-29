package com.example.demo.Controllers;

import com.example.demo.Models.Member;
import com.example.demo.Models.MemberService;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageControllers {



    @GetMapping("/")
    public String start(Model model) {

        return "MainPage/MainPage";
    }

    @GetMapping("/home")
    public String home(Model model) {

        return "MainPage/MainPage";
    }

    @GetMapping("/cards")
    public String cards(){

        return "HoverPages/Cards/Cards";
    }

    @GetMapping("/credits")
    public String credits(){

        return "HoverPages/Credits/Credits";
    }

    @GetMapping("/depositions")
    public String depositions(){

        return "HoverPages/Depositions/Depositions";
    }

    @GetMapping("/services")
    public String services(){
        return "MenuPagesHTML/Services";
    }

    @GetMapping("/contact")
    public String contact(){
        return "MenuPagesHTML/Contact";
    }



    @Autowired
    MemberService memberService;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "SignInPage/SignIn";
    }
    @PostMapping("/register")
    public String registerMember(
            @RequestParam String first_name, @RequestParam String last_name,
            @RequestParam String password, @RequestParam String email){
        Member member = new Member(email, first_name, last_name, password);

        memberService.createMember(member);

        return "SignInPage/SignIn";
    }


    private final Member member;

    @Autowired
    public MainPageControllers(Member member) {
        this.member = member;
    }


    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("member", new Member());
        System.out.println("!!!!!!!!!!!");
        return "SignInPage/SignIn";
    }

    @PostMapping("/login")
    public String loginMember(
            @RequestParam String email,
            HttpSession session){
        session.setAttribute("email", email);
        System.out.println(session.getAttribute("email"));
        System.out.println("!!!!!!!!!!");



        return "PersonalPage/PersonalPage";
    }

}
