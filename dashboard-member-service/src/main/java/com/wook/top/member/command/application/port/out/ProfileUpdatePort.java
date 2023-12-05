package com.wook.top.member.command.application.port.out;

import com.wook.top.member.command.domain.model.Member;
import java.util.Optional;

public interface ProfileUpdatePort {
	Optional<Member> findMemberById(Long memberId);
}
