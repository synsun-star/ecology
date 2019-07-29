package com.kakao.ecology.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "program")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String category;

    @ManyToOne(targetEntity = Region.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private Region region;

    @Column
    private String info;

    @Column(columnDefinition = "TEXT")
    private String detailInfo;
}
