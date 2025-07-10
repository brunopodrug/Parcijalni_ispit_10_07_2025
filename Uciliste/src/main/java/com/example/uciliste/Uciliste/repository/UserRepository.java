package com.example.uciliste.Uciliste.repository;

import com.example.uciliste.Uciliste.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}