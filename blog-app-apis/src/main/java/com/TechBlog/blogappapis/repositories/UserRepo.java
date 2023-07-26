package com.TechBlog.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TechBlog.blogappapis.entities.User;
public interface UserRepo extends JpaRepository< User, Integer> {

}
