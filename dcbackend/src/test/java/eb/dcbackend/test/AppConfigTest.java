package eb.dcbackend.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@ComponentScan(basePackages = {"eb.dcbackend"})
public class AppConfigTest {
              @Bean
              public PasswordEncoder passwordEncoder() {
                  return new BCryptPasswordEncoder();
              }
}
