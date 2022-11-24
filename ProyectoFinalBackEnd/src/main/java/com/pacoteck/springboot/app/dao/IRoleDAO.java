package com.pacoteck.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacoteck.springboot.app.dto.Role;

public interface IRoleDAO extends JpaRepository<Role, Long>{

}
