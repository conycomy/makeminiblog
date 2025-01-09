package me.imgyeong.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // created_at, updated_at 자동 업데이트 해주는 어노테이션
@SpringBootApplication
public class SpringBootDeveloperApplication {
	public static void main(String[] args){
		SpringApplication.run(SpringBootDeveloperApplication.class, args);
	}
}
