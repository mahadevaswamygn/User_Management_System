package com.Geeksterasmt.UserManagementSystem.cotroller;

import com.Geeksterasmt.UserManagementSystem.model.User;
import com.Geeksterasmt.UserManagementSystem.service.UserSerive;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.annotation.Nullable;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")

public class userController {
    @Autowired
    UserSerive uService;
    @PostMapping("/saveuser")
    public ResponseEntity<String> saveUser(@RequestBody String reuser)
    {
       JSONObject json = new JSONObject(reuser);
        List<String> validList = ValidUser(json);
        if(validList.isEmpty())
        {
            User user=setUser(json);

            uService.saveUser(user);
            return new ResponseEntity<>("User saved", HttpStatus.CREATED);

        }
        else {
            String[] answer = Arrays.copyOf(validList.toArray(), validList.size(), String[].class);

            return new ResponseEntity<>(Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }

    }
    public User setUser(JSONObject json)
    {
        User user = new User();
        if(json.has("id")) {
            String UserId = json.getString("id");
            user.setId(Integer.valueOf(UserId));
        }
        String userName=json.getString("userName");
        user.setUserName(userName);
        String userDOb=json.getString("dateOfBirth");
        user.setUserName(userDOb);
        String useremail=json.getString("email");
        user.setUserName(useremail);
        String userphoneNumber=json.getString("phoneNumber");
        user.setUserName(userphoneNumber);
        if(json.has("date")) {
            String userdate = json.getString("date");
            user.setUserName(userdate);
        }
        if(json.has("userTime")) {
            String usertime = json.getString("userTime");
            user.setUserName(usertime);
        }
        return user;


    }
    private List<String> ValidUser(JSONObject json) {
        List<String> errorList = new ArrayList<>();

        if(!json.has("userName"))
        {
            errorList.add("userName");
        }
        if(!json.has("dateOfBirth"))
        {
            errorList.add("dateOfBirth");
        }
        if(!json.has("email"))
        {
            errorList.add("email");
        }

        if(!json.has("phoneNumber"))
        {
            errorList.add("phoneNumber");
        }

        return errorList;


    }
    @GetMapping("getuser")
    public List<User> getuser(@Nullable  @RequestParam Integer id)
    {
        return  uService.getuser(id);
    }
    @DeleteMapping("deleteuser/id/{id}")
    public void deleteuser(@PathVariable Integer id)
    {
        uService.deleteuser(id);
    }

    @PutMapping("updateuser/id/{id}")
    public void updateuser(@PathVariable Integer id,@RequestBody User user)
    {
        uService.updateUser(id,user);
    }

}
