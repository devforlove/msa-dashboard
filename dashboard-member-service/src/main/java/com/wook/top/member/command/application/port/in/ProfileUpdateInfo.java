package com.wook.top.member.command.application.port.in;

import lombok.Builder;

@Builder
public record ProfileUpdateInfo(String nickname, String profileImageUrl) {

}
