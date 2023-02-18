package com.Geeksterasmt.UserManagementSystem.service;

import com.Geeksterasmt.UserManagementSystem.model.User;
import com.Geeksterasmt.UserManagementSystem.reposotory.UserReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSerive {
    private static List<User> users=new ArrayList<>();
    @Autowired
    UserReposotory userRep;

    public void saveUser(User user)
    {
         userRep.save(user);
    }
    public List<User> getuser(Integer id)
    {
        List<User> users;
        if(id == null)
        {
            users=userRep.findAll();
        }
        else {
            users = new ArrayList<>();
            users.add(userRep.findById(id).get());
        }
        return  users;
    }
    public void updateUser(Integer id,User newuser)
    {
        User olduser=userRep.findById(id).get();
        olduser.setId(newuser.getId());
        olduser.setUserName(newuser.getUserName());
        olduser.setDateOfBirth(newuser.getDateOfBirth());
        olduser.setEmail(newuser.getEmail());
        olduser.setPhoneNumber(newuser.getPhoneNumber());
        olduser.setDate(newuser.getDate());
        olduser.setUserTime(newuser.getUserTime());

        userRep.save(newuser);
    }

    public void deleteuser(Integer id)
    {
        User user =userRep.findById(id).get();
        userRep.delete(user);
    }

}
