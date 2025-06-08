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