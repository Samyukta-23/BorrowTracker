package com.example.BorrowTracker.Controller;

import com.example.BorrowTracker.Entity.AppUser;
import com.example.BorrowTracker.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:3000")
public class AuthController{

    private final UserRepository repo;

    public AuthController(UserRepository repo){
        this.repo=repo;
    }
    @PostMapping("/register")
    public String register(@RequestBody AppUser user){
        if (repo.findByUsername(user.getUsername()).isPresent()){
            return "USER_ALREADY_EXISTS";
        }
        repo.save(user);
        return "REGISTERED";
    }
    @PostMapping("/login")
    public String login(@RequestBody AppUser user){
        AppUser existing = repo.findByUsername(user.getUsername())
                .orElse(null);

        if (existing==null){
            return "USER_NOT_FOUND";
        }

        if (existing.getPassword().equals(user.getPassword())){
            return "SUCCESS";
        }

        return "INVALID_PASSWORD";
    }
}