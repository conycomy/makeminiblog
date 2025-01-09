package me.imgyeong.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.imgyeong.springbootdeveloper.domain.Article;
import me.imgyeong.springbootdeveloper.dto.AddArticleRequest;
import me.imgyeong.springbootdeveloper.dto.ArticleResponse;
import me.imgyeong.springbootdeveloper.dto.UpdateArticleRequest;
import me.imgyeong.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogApiController {
	private final BlogService blogService;

	// HTTP 메서드가 POST 일때 전달받은 URL과 동일 하면 메서드로 매핑
	@PostMapping("/api/articles")
	//@RequestBody로 요청 본문 값 매핑
	public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
		Article savedArticle = blogService.save(request);
		// 요청한 자원이 성공적 으로 생성 되었으며 저장된 블로그 글 정보를 응답 객체에 전송
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(savedArticle);
	}

	@GetMapping("/api/articles")
	public ResponseEntity<List<ArticleResponse>> findAllArticles() {
		List<ArticleResponse> articles = blogService.findAll()
			.stream()
			.map(ArticleResponse::new)
			.toList();

		return ResponseEntity.ok()
			.body(articles);
	}

	@GetMapping("/api/articles/{id}")
	// URL 경로에서 값 추출
	public ResponseEntity<ArticleResponse> findArticle(@PathVariable(name = "id") long id) {
		Article article = blogService.findById(id);

		return ResponseEntity.ok()
			.body(new ArticleResponse(article));
	}

	@DeleteMapping("/api/articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable(name = "id") long id) {
		blogService.delete(id);

		return ResponseEntity.ok()
			.build();
	}

	@PutMapping("/api/articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable(name = "id") long id,
												 @RequestBody UpdateArticleRequest request) {
		Article updatedArticle = blogService.update(id, request);

		return ResponseEntity.ok()
			.body(updatedArticle);
	}
}