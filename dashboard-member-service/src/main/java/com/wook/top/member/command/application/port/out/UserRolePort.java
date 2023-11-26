package com.wook.top.member.command.application.port.out;

import com.wook.top.member.command.domain.model.UserRole;
import com.wook.top.webcore.member.Role;

public interface UserRolePort {

	UserRole findByName(Role role);
}
