package com.bickyraj.demo.userservice.user.domain.repository;

import com.bickyraj.demo.userservice.user.domain.entity.UserEntity;

public interface UserRepository {
    boolean save(UserEntity user);
}
