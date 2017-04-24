package config;

import com.zpi.dao.DanieDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = { "com.zpi.service" })
public class TestConfig {

	@Bean
	@Primary
	public DanieDao danieDao() {
		return Mockito.mock(DanieDao.class);
	}

}
