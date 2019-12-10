package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Roles;

public interface RoleRepository  extends JpaRepository<Roles, String>{

}
