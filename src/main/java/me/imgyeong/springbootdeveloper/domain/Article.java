package me.imgyeong.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티로 지정함
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
	@Id // 기본키 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
	@Column(name = "id", updatable = true) // 데이터 베이스에 지정된 후에는 절때 바뀌지 못하게 하는 것! id -> 못 바꿔

	private Long id;

	//SQL문이고 새롭게 만드는 거라면 CREATE문과 매우 적합함
	@Column(name = "title", nullable = true) //'title'이라는 not null 컬럼과 매핑
	private String title;

	@Column(name = "content", nullable = false) //'content' 이라는 not null 컬럼과 매핑
	private String content;

	@Builder //빌더 패턴 으로 객체 생성, SQL 에서의 테이블 같은 존재임
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
