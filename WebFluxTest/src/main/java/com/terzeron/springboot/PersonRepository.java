package com.terzeron.springboot;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// 첫번째 템플릿 파라미터는 테이블로 저장될 클래스
// 두번째는 findById()에 의해 사용될 id 속성의 타입
public interface PersonRepository extends ReactiveCrudRepository<Sir, Long> {

}
