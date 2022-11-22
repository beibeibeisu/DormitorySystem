package com.fjl.service.Impl;

import com.fjl.mapper.buildingMapper;
import com.fjl.mapper.dormitoryMapper;
import com.fjl.mapper.studentMapper;
import com.fjl.pojo.building;
import com.fjl.pojo.dormitory;
import com.fjl.service.buildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class buildingServiceImpl implements buildingService {
    @Autowired
    private buildingMapper buildingMapper;
    @Autowired
    private dormitoryMapper dormitoryMapper;
    @Autowired
    private studentMapper studentMapper;
    @Override
    public List<building> findList() {
        return buildingMapper.findList();
    }

    @Override
    public int updateOne(building building) {
        return buildingMapper.updateOne(building);
    }

    @Override
    public int insertOne(building building) {
        return buildingMapper.insertOne(building);
    }

    @Override
    public List<building> likeSearch(String key, String value) {
        if (value.equals(""))
            return this.findList();
        switch (key){
            case "name":
                return buildingMapper.likeSearchByName(value);
            case "introduction":
                return buildingMapper.likeSearchByIntroduction(value);
        }
        return null;
    }

    @Transactional
    @Override
    public void delete(int id) {
        //1.查询出该楼宇所包含的宿舍ID
        //2.查出该宿舍所包含的学生
        //3.查出空宿舍 将该学生放入
        //4.删除该宿舍
        //5.删除该楼宇
        List<Integer> dormitoryIds = dormitoryMapper.findByBuildingId(id);
        for (Integer dormitoryId:dormitoryIds){
            List<Integer> studentIds = studentMapper.findStudentByDormitoryId(dormitoryId);
            for (Integer studentId:studentIds){
                List<Integer> AvailableIds = dormitoryMapper.findOneAvailable();
                for (Integer availableId:AvailableIds){
                    if (dormitoryIds.contains(availableId))continue;
                    else {
                        studentMapper.updateDormitoryId(studentId,availableId);
                        dormitoryMapper.updateDeclineAvailable(availableId);
                        break;
                    }
                }
            }
            dormitoryMapper.deleteOneByDormitoryId(dormitoryId);
        }
        buildingMapper.deleteOneBuildingById(id);
    }

    @Override
    public List<building> findByAdminId(int id) {
        return buildingMapper.findByAdminId(id);
    }

    @Override
    public Integer findOneAdminId(int buildingId) {
        return buildingMapper.findDormitoryAdminId(buildingId);
    }
}
