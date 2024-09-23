package com.shoppingmall.repository;

import com.shoppingmall.model.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findByUsername(String username);
}
