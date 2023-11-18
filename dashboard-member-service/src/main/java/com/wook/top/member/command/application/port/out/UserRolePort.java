package com.wook.top.member.command.application.port.out;

import com.wook.top.member.command.domain.model.Role;
import com.wook.top.member.command.domain.model.UserRole;

public interface UserRolePort {

	UserRole findByName(Role role);
}
