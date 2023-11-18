package com.wook.top.member.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.member.command.application.port.out.UserRolePort;
import com.wook.top.member.command.domain.model.Role;
import com.wook.top.member.command.domain.model.UserRole;
import com.wook.top.member.command.domain.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserUserRoleAdapter implements UserRolePort {
	private final UserRoleRepository userRoleRepository;

	@Override
	public UserRole findByName(Role role) {
		return userRoleRepository.findByName(role);
	}
}
