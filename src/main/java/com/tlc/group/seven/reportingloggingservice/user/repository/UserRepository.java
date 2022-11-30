package com.tlc.group.seven.reportingloggingservice.user.repository;

import com.tlc.group.seven.reportingloggingservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
