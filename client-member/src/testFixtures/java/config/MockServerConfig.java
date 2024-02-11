package config;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MockServerConfig {

	@Bean(initMethod = "start", destroyMethod = "stop")
	public WireMockServer mockServer() {
		return new WireMockServer(8061);
	}
}
