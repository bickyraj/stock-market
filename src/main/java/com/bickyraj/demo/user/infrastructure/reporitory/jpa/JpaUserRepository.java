package com.bickyraj.demo.user.infrastructure.reporitory.jpa;

import com.bickyraj.demo.user.infrastructure.reporitory.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserModel, Long> {
}
