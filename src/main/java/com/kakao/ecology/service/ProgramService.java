package com.kakao.ecology.service;

import com.kakao.ecology.entity.Program;
import com.kakao.ecology.entity.Region;
import com.kakao.ecology.repository.ProgramRepository;
import com.kakao.ecology.repository.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProgramService {
    private final static Logger logger = LoggerFactory.getLogger(ProgramService.class);

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    RegionRepository regionRepository;

    public Program getProgram(String code) {
        return programRepository.findById(Long.parseLong(code)).orElse(null);
    }

    public List<Region> getRegion(String name) {
        return regionRepository.findByNameLike("%"+name+"%");
    }

    public int getKeywordCountAtInfoGroupByRegion(String keyword) {
        /*
        생태 정보 데이터에 "프로그램 소개” 컬럼에서 특정 문자열이 포함된 레코드에서 서비스
        지역 개수를 세어 출력하는 API 를 개발하세요.
        o 예를 들어, “세계문화유산” 문자열을 입력 받아 포함된 레코드에서 서비스 지역
        개수와 지역정보를 출력
            입력 {
            “keyword”:”세계문화유산”
            }
            출력{
            “keyword”: “세계문화유산”,
            “programs” : [
            {
            “region”:”경상북도 경주시”,
            “count”: 2
            }
            ]
            }
        */
        return 0;
    }

    public int getKeywordCountAtAll(String keyword) {
        /*
        모든 레코드에 프로그램 상세 정보를 읽어와서 입력 단어의 출현빈도수를 계산하여 출력
        하는 API 를 개발하세요.
            입력{
            “keyword”:”문화”
            }
            출력{
            “keyword”: “문화”,
            “count” : 20
            }
        */
        return 0;
    }
}
