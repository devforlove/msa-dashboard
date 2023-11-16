package com.wook.top.member.command.domain.repository;

import com.wook.top.member.command.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
