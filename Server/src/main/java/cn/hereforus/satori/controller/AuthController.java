package cn.hereforus.satori.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.hereforus.satori.entity.Auth;

@RestController
public class AuthController {
    @PostMapping("/auth/login")
    public String login(
            @RequestBody Auth auth
    ) {
        System.out.println("login");
        System.out.println(auth.username);
        System.out.println(auth.password);
        return "success";
    }

    @PostMapping("/auth/register")
    public String register(
            @RequestBody Auth auth
    ) {
        System.out.println("register");
        System.out.println(auth.username);
        System.out.println(auth.password);
        return "success";
    }
}
