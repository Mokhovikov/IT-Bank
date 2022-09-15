package com.example.demo.Controllers;

import com.example.demo.Models.Member;
import com.example.demo.Models.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    MemberServiceImpl memberServiceImpl;

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
        memberServiceImpl.createMember(member);

        return "SignInPage/SignIn";
    }


    private final Member member;

    @Autowired
    public MainPageControllers(Member member) {
        this.member = member;
    }


    @GetMapping("/loginPage")
    public String loginForm(Model model){
        model.addAttribute("member", new Member());
        System.out.println("!!!!!!!!!!!");
        return "SignInPage/SignIn";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("member", new Member());
        System.out.println("!!!!!!!!!!!");
        return "SignInPage/SignIn";
    }


}
