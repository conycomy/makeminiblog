package me.imgyeong.springbootdeveloper.repository;

import me.imgyeong.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

	public interface BlogRepository extends JpaRepository<Article, Long> {
	}