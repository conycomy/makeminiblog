package me.imgyeong.springbootdeveloper.service;


import lombok.RequiredArgsConstructor;
import me.imgyeong.springbootdeveloper.domain.Article;
import me.imgyeong.springbootdeveloper.dto.AddArticleRequest;
import me.imgyeong.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
	private final BlogRepository blogRepository;

		public Article save(AddArticleRequest request){
		return blogRepository.save(request.toEntity());
		}

}
