package com.kakao.ecology.service;

import com.kakao.ecology.repository.ProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProgramService {
    private final static Logger logger = LoggerFactory.getLogger(ProgramService.class);

    @Autowired
    ProgramRepository programRepository;
}
