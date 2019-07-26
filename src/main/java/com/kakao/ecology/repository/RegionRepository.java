package com.kakao.ecology.repository;

import com.kakao.ecology.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RegionRepository extends JpaRepository<Region, Long> {
}