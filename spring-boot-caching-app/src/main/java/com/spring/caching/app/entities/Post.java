package com.spring.caching.app.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "`posts_table`")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;


    @Lob
    @Column
    private String content;


    @OneToMany(mappedBy = "post")
    @ToString.Exclude
    private Set<Comment> comments;

}

