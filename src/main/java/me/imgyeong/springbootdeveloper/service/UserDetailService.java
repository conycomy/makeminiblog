package me.imgyeong.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.imgyeong.springbootdeveloper.domain.User;
import me.imgyeong.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

	private final UserRepository userRepository;
	//스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스

	@Override
	public User loadUserByUsername(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new IllegalArgumentException((email)));
	}
}