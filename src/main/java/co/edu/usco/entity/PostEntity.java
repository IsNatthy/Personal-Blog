package co.edu.usco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
        name = "posts"
)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "user_id"
    )
    private UserEntity user;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL
    )
    private List<CommentEntity> comments = new ArrayList<>();

}