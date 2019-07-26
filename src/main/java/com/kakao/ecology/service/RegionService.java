package com.kakao.ecology.service;

import com.kakao.ecology.entity.Region;
import com.kakao.ecology.repository.ProgramRepository;
import com.kakao.ecology.repository.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegionService {
    private final static Logger logger = LoggerFactory.getLogger(RegionService.class);

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    ProgramRepository programRepository;

    public Region getProgramsByRegion() {
        Region region = new Region();
        /*
        생태 관광지 중에 서비스 지역 컬럼에서 특정 지역에서 진행되는 프로그램명과 테마를
        출력하는 API 를 개발하세요.
        o 예를들어, “평창군”이라는 문자열을 입력 받으면 아래와 같은 결과를 출력합니다.
        o 단, 출력 결과에 지역은 지역 코드를 출력합니다.
            입력 {
            “region”:”평창군”
            }
            출력 {
            “region”: “reg3726”,
            “programs” : [
            {
            “prgm_name”:”오감만족! 오대산 에코 어드벤처 투어”,
            “theme”:”아동 청소년 체험학습”
            },
            {
            “prgm_name”:”오대산국립공원 힐링캠프”,
            “theme”:”숲 치유”
            },
            ...
            ]
            }
        */
        return region;
    }



}
