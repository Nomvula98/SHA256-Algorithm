package com.sha256.hashing.service;

import com.sha256.hashing.sha256algorithm.SHA256;
import com.sha256.hashing.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    SHA256 sha256 = new SHA256();
    UserDetails encryptUserDetails = new UserDetails();

    /**
     * Service for user registration with ecrypted password
     */
    public String reg(UserDetails userDetails){
        userDetails.setPassword(sha256.getSHA256Hash(userDetails.getPassword()));
        userRepo.save(userDetails);
        return "Successfuly registered";
    }

    /**
     * Service for logging in a registered user
     */
    public String login(String username, String password){
      Optional<UserDetails> user = userRepo.findByUsername(username);
        encryptUserDetails.setPassword(sha256.getSHA256Hash(password));
            if (user.get().getPassword().equals(encryptUserDetails.getPassword())){
                return "Successfuly logged in";
            }
            else{
                return "Login failed";
        }

    }
}
