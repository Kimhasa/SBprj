package idusw.springboot.kjymall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
