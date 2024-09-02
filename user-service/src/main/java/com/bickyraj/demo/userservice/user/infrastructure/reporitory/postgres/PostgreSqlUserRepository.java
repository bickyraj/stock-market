package com.bickyraj.demo.userservice.user.infrastructure.reporitory.postgres;

import com.bickyraj.demo.userservice.user.domain.repository.UserRepository;
import com.bickyraj.demo.userservice.user.infrastructure.reporitory.jpa.JpaUserRepository;
import com.bickyraj.demo.userservice.user.domain.entity.UserEntity;
import com.bickyraj.demo.userservice.user.infrastructure.reporitory.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostgreSqlUserRepository implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    @Override
    public boolean save(UserEntity user) {
        jpaUserRepository.save(UserModel.fromEntity(user));
        return true;
    }
}
