package idusw.springboot.kjymall.entitiy;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="member")

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 20, nullable = false)
    private String id;
    @Column(length = 20, nullable = false)
    private String pw;
    @Column(length = 20, nullable = true)
    private String name;
    @Column(length = 30, nullable = false)
    private String email;
}
