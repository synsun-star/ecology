package com.kakao.ecology.service;

import com.kakao.ecology.entity.Program;
import com.kakao.ecology.entity.Region;
import com.kakao.ecology.repository.ProgramRepository;
import com.kakao.ecology.repository.RegionRepository;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CsvService {
    private final static Logger logger = LoggerFactory.getLogger(CsvService.class);

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    RegionRepository regionRepository;

    public void loadProgramsByCSV(MultipartFile file) throws IOException {

        String content = new String(file.getBytes(), "euc-kr");
        CSVReader reader = new CSVReader(new StringReader(content));
        for (String[] record : reader) {
            if (isStringInt(record[0]) && record.length == 6) {  // 첫열이 숫자인 경우만 입력한다. 아닌 경우 주석이거나 잘못된 데이터.
//                System.out.println(record[0]);  // 번호
                Program program = new Program();
                Region region = regionRepository.findByNameEquals(record[3]);
                if(region == null) {
                    region = new Region();
                    region.setName(record[3]);
                    region = regionRepository.save(region);
                }
                program.setName(record[1]);
                program.setCategory(record[2]);
                program.setRegion(region);
                program.setInfo(record[4]);
                program.setDetailInfo(record[5]);
                program = programRepository.save(program);

                List<Program> programs = region.getProgramList();
                if(programs == null) programs = new ArrayList<Program>();
                programs.add(program);
                region.setProgramList(programs);
                region = regionRepository.save(region);

//                System.out.println(record[1]);  // 프로그램명
//                System.out.println(record[2]);  // 테마별 분류
//                System.out.println(record[3]);  // 서비스 지역
//                System.out.println(record[4]);  // 프로그램 소개
//                System.out.println(record[5]);  // 프로그램 상세 소개
            }
        }
    }

    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
}
