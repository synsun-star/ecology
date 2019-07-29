package com.kakao.ecology.rest;

import com.kakao.ecology.entity.Region;
import com.kakao.ecology.service.ProgramService;
import com.kakao.ecology.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramController {

    @Autowired
    public ProgramService programService;

    @Autowired
    public RegionService regionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Region> getProgramByRegionCode(@RequestParam("region") String region) {
        return programService.getRegion(region);
    }

    @RequestMapping(value = "/region", method = RequestMethod.GET)
    public List<Region> getProgramByRegionName(@RequestParam("region") String region) {
        return regionService.getRegion(region);
    }

}
