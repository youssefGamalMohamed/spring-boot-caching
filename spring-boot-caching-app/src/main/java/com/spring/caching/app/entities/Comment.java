package com.spring.caching.app.entities;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "`comments_table`")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Lob
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id_fk")
    private Post post;

}
