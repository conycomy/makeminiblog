package me.imgyeong.springbootdeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {
	@Autowired // 의존성 주입
	protected MockMvc mockMvc; // 웹 어플리케이션 테스트용 라이브러리

	@Autowired
	private WebApplicationContext context;

	@BeforeEach //테스트 메서드 실행 이전에 실행되는거!
	public void mockMvcSetup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
			.build();
	}
}