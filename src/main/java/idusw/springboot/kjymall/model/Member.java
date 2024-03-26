package idusw.springboot.kjymall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// boilerplate code : 상용구 코드, 뻔한 코드
// Annotation : 컴파일러에게 처리를 요청하는 부연 설명
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member { // DTO or VO(vlaueable Object)

    private Long idx;

    private String id;

    private String pw;

    private String name;

    private String email;

}
