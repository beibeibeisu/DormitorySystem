package com.fjl.service.Impl;

import com.fjl.mapper.dormitoryAdminMapper;
import com.fjl.mapper.dormitoryMapper;
import com.fjl.mapper.studentMapper;
import com.fjl.pojo.dormitory;
import com.fjl.pojo.dormitoryAdmin;
import com.fjl.pojo.dormitoryAdminExample;
import com.fjl.service.dormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class dormitoryServiceImpl implements dormitoryService {

    @Autowired
    private dormitoryAdminMapper dormitoryAdminMapper;
    @Autowired
    private dormitoryMapper dormitoryMapper;
    @Autowired
    private studentMapper studentMapper;
    @Override
    public List<dormitoryAdmin> getList() {
        return dormitoryAdminMapper.selectByExample(null);
    }

    @Override
    public List<dormitoryAdmin> search(String key, String value) {
        //当value是空的时候 查询全部信息
        if (value.equals(""))
            return this.getList();
        dormitoryAdminExample dormitoryAdminExample = new dormitoryAdminExample();
        //三种选择下的模糊查询
        System.out.println(key+"----"+value);
        switch (key){
            case "username":
                dormitoryAdminExample.createCriteria().andUsernameLike("%"+value+"%");
                return dormitoryAdminMapper.selectByExample(dormitoryAdminExample);
            case "name":
                dormitoryAdminExample.createCriteria().andNameLike("%"+value+"%");
                return dormitoryAdminMapper.selectByExample(dormitoryAdminExample);
            case "telephone" :
                dormitoryAdminExample.createCriteria().andTelephoneLike("%"+value+"%");
                return dormitoryAdminMapper.selectByExample(dormitoryAdminExample);
        }
        return null;
    }

    @Override
    public int insertOne(dormitoryAdmin dormitoryAdmin) {
        return dormitoryAdminMapper.insert(dormitoryAdmin);
    }

    @Override
    public int deleteOne(int id) {
        return dormitoryAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOne(dormitoryAdmin dormitoryAdmin) {
        return dormitoryAdminMapper.updateByPrimaryKeySelective(dormitoryAdmin);
    }

    @Override
    public List<dormitory> listAndBuildingName() {
        return dormitoryMapper.listAndBuildingName();
    }

    @Override
    public int insertOneDormitory(dormitory dormitory) {
        return dormitoryMapper.insetOneDormitory(dormitory);
    }

    @Override
    public int updateDormitoryMessage(dormitory dormitory) {
        return dormitoryMapper.updateOneById(dormitory);
    }

    @Override
    public List<dormitory> likeSearch(String key, String value) {
        if (value.equals(""))
            return this.listAndBuildingName();
        switch (key){
            case "name":
                return dormitoryMapper.likeSearchByName(value);
            case "telephone":
                return dormitoryMapper.likeSearchByTelephone(value);
        }
        return null;
    }

    @Override
    public int deleteOneDormitory(int id) {
        //1.查询出该宿舍包含的学生
        //2.将该学生移到有空位的宿舍
        //3.删除该宿舍
        List<Integer> studentIds = studentMapper.findStudentByDormitoryId(id);
        for (Integer studentId:studentIds){
            List<Integer> AvailableIds = dormitoryMapper.findOneAvailable();
            for (Integer availableId:AvailableIds){
                if (availableId==id)continue;
                else {
                    studentMapper.updateDormitoryId(studentId,availableId);
                    dormitoryMapper.updateDeclineAvailable(availableId);
                    break;
                }
            }
        }
        dormitoryMapper.deleteOneByDormitoryId(id);
        return 1;
    }

    @Override
    public List<dormitory> findByBuildingId(int buildingId) {
        return dormitoryMapper.findByBuildingId02(buildingId);
    }
}
