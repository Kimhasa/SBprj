package idusw.springboot.kjymall.model;


import lombok.*;

// lombok annotation - boilerplate code를 다루기 위한 라이브러리
// POJO, Beans
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Member { // POJO : plain old java object = java beans
    private Long idx;
    private String id;
    private String pw;
    private String name;
    private String email;


}
