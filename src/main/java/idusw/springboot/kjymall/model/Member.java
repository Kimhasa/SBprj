package idusw.springboot.kjymall.model;

import lombok.*;

// boilerplate code : 상용구 코드, 뻔한 코드
// Annotation : 컴파일러에게 처리를 요청하는 부연 설명
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor

@Data
@Builder // 디자인패턴중 하나로 생성시 명확성을 제공함
public class Member { // DTO or VO(vlaueable Object)

    private Long idx;

    private String id;

    private String pw;

    private String name;

    private String email;

}
