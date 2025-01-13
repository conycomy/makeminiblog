package me.imgyeong.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.imgyeong.springbootdeveloper.dto.AddUserRequest;
import me.imgyeong.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

	private final UserService userService;

	@PostMapping("/user")
	public String signup(AddUserRequest request){
		userService.save(request);
		return "redirect:/login";
	}
}
