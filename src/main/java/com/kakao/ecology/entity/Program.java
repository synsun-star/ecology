package com.kakao.ecology.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    @OneToOne
    @JoinColumn(name = "regionId")
    @JsonIgnore
    private Region region;

    @Column
    private String info;

    @Column
    private String detailInfo;
}
