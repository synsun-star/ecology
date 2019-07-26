package com.kakao.ecology.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "region")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    
    @OneToMany
    @JoinColumn(name = "programId")
    @JsonIgnore
    private Program programs;
}
