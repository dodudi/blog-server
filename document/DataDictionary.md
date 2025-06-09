## 📦 클래스명: Post

| 속성명              | 타입       | 설명        | 제약조건      | 예시값                        |
|------------------|----------|-----------|-----------|----------------------------|
| id               | Long     | 포스트 고유 ID | PK, 자동 증가 | 1                          |
| title            | String   | 포스트 제목    | Not Null  | this is title              |
| content          | String   | 마크다운 문자열  | Not Null  | markdown content           |
| author           | String   | 포스트 작성자   | Not Null  | rudy                       |
| format           | String   | 포스트 형식    | Not Null  | md                         |
| create_date_time | DateTime | 포스트 작성일   | Not Null  | 2025-06-09 12:20:55.000000 |
| update_date_time | DateTime | 포스트 수정일   | Not Null  | 2025-06-09 15:20:55.000000 |

---

## 📦 클래스명: PostTag

| 속성명              | 타입       | 설명                    | 제약조건      | 예시값                        |
|------------------|----------|-----------------------|-----------|----------------------------|
| id               | Long     | 포스트 + 태그 중간 테이블 고유 ID | PK, 자동 증가 | 1                          |
| post             | Post     | 포스트 연관관계              | Not Null  | 1                          |
| tag              | Tag      | 태그 연관관계               | Not Null  | 1                          |
| create_date_time | DateTime | 중간 테이블 작성일            | Not Null  | 2025-06-09 12:20:55.000000 |
| update_date_time | DateTime | 중간 테이블 수정일            | Not Null  | 2025-06-09 15:20:55.000000 |

---

## 📦 클래스명: Tag

| 속성명              | 타입       | 설명         | 제약조건      | 예시값                        |
|------------------|----------|------------|-----------|----------------------------|
| id               | Long     | 태그 고유 ID   | PK, 자동 증가 | 1                          |
| tagName          | String   | 태그 이름      | Not Null  | 1                          |
| create_date_time | DateTime | 중간 테이블 작성일 | Not Null  | 2025-06-09 12:20:55.000000 |
| update_date_time | DateTime | 중간 테이블 수정일 | Not Null  | 2025-06-09 15:20:55.000000 |

---