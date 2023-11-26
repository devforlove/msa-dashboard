package com.wook.top.member.command.domain.repository;

import com.wook.top.member.command.domain.model.UserRole;
import com.wook.top.webcore.member.Role;
import org.springframework.data.repository.Repository;

public interface UserRoleRepository extends Repository<UserRole, Long> {

	UserRole findByName(Role role);
}
