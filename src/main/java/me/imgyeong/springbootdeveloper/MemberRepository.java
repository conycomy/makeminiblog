package me.imgyeong.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	// 필요한 경우 커스텀 메서드 추가 가능
}
