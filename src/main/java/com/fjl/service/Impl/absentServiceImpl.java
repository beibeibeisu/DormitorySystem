package com.fjl.service.Impl;

import com.fjl.mapper.absentMapper;
import com.fjl.pojo.absent;
import com.fjl.service.absentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class absentServiceImpl implements absentService {
    @Autowired
    private absentMapper absentMapper;
    @Override
    public List<absent> findAllAbsent() {
        return absentMapper.findList();
    }

    @Override
    public List<absent> likeSearch(String key, String value) {
        if (value.equals(""))
            return this.findAllAbsent();
        switch (key){
            case "buildingName":
                return absentMapper.likeSearchByBuildingName(value);
            case "dormitoryName":
                return absentMapper.likeSearchByDormitoryName(value);
        }
        return null;
    }

    @Override
    public int insertOne(absent absent) {
        return absentMapper.insertOne(absent);
    }
}
