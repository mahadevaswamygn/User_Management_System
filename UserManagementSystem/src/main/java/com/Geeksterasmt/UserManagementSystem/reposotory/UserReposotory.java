package com.Geeksterasmt.UserManagementSystem.reposotory;

import com.Geeksterasmt.UserManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposotory extends JpaRepository<User,Integer> {
}
