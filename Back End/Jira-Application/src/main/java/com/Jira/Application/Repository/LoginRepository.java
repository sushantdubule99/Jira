package com.Jira.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jira.Application.Entity.LogIn;
@Repository
public interface LoginRepository extends JpaRepository<LogIn, Long> {

}
