import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JUnitCycleTest {
	@BeforeAll // 전체 테스트를 시작하기 전에 1회 실행해줌 , static으로 선언해줘야함
	static void beforeEach() {
		System.out.println("@BeforeEach");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}

	@Test
	public void test2() {
		System.out.println("test2");
	}

	@Test
	public void test3() {
		System.out.println("test3");
	}

	@AfterAll // 전체 테스트를 마치고 종료하기 전에 1회 실행하므로 메서드는 static으로 선언함
	static void afterAll() {
		System.out.println("@AfterAll");
	}

	@AfterEach // 테스트 케이스를 종료하기 전마다 실행
	public void afterEach() {
		System.out.println("@AfterEach");
	}

}
