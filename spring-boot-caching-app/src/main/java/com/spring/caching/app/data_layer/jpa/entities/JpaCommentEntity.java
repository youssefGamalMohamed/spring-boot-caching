package com.spring.caching.app.data_layer.jpa.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "`comments_table`")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JpaCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Lob
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id_fk")
    private JpaPostEntity jpaPostEntity;

}
