package com.wook.top.member.command.domain.repository;

import com.wook.top.member.command.domain.model.Role;
import com.wook.top.member.command.domain.model.UserRole;
import org.springframework.data.repository.Repository;

public interface UserRoleRepository extends Repository<UserRole, Long> {

	UserRole findByName(Role role);
}
