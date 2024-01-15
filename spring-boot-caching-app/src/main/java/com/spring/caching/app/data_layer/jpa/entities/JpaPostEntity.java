package com.spring.caching.app.data_layer.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "`posts_table`")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class JpaPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;


    @Lob
    @Column
    private String content;


    @OneToMany(mappedBy = "jpaPostEntity")
    @ToString.Exclude
    private Set<JpaCommentEntity> comments;

}

