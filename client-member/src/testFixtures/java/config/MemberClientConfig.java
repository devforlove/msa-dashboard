package config;

import static org.mockito.Mockito.mock;

import com.wook.top.memberclient.client.MemberClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MemberClientConfig {

	@Bean("memberClient")
	public MemberClient memberClient() {
		return mock(MemberClient.class);
	}
}
