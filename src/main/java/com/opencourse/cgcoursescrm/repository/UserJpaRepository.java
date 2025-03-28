package com.opencourse.cgcoursescrm.repository;

import com.opencourse.cgcoursescrm.domain.model.User;
import com.opencourse.cgcoursescrm.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

}
