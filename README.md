# 저장소 설명
인프런 `토비의 스프링 6` 실습 페이지

# 템플릿


# 예외
예외를 체계적으로 만들어서 필요한 경우에 예외를 잘 캐치해서 처리하도록 하자. 

# 서비스 
## 서비스의 종류
애플리케이션 서비스
- `@Service` 애노테이션 사용

도메인 서비스
- 특정 엔티티로는 표현하기 힘든 로직을 사용

인프라 서비스
- 서비스 추상화의 대상 

## 서비스 추상화 대상
인프라 서비스
- 도메인/애플리케이션 로직에 참여하지 않는, 기술을 제공하는 서비스
