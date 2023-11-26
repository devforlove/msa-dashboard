package com.wook.top.member.config.security;

import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.model.UserRole;
import com.wook.top.member.command.domain.repository.MemberRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member =  memberRepository.findByMemberInfoEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("email (%s) not found", email)));

		return new SecurityUser(
				member.getMemberId(),
				member.getMemberInfo().getEmail(),
				member.getPasswordInfo().getPassword(),
				member.getMemberInfo().getNickname(),
				member.getRoles().stream().map(UserRole::getName).collect(Collectors.toSet())
		);
	}
}
