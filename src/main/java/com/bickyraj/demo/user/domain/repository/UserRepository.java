package com.bickyraj.demo.user.domain.repository;

import com.bickyraj.demo.user.domain.entity.UserEntity;

public interface UserRepository {
    boolean save(UserEntity user);
}
