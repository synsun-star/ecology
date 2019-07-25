package com.kakao.ecology.repository;

import com.kakao.ecology.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProgramRepository extends JpaRepository<Program, Long> {
}
