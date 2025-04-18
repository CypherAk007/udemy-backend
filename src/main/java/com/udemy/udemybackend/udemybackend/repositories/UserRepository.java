package com.udemy.udemybackend.udemybackend.repositories;

import com.udemy.udemybackend.udemybackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
