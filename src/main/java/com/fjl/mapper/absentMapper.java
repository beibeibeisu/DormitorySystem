package com.fjl.mapper;

import com.fjl.pojo.absent;

import java.util.List;

public interface absentMapper {
    /**
     * 得到所有缺勤学生的信息
     * @return
     */
    List<absent>findList();

    /**
     * 根据楼宇名称进行模糊查询
     * @param buildingName
     * @return
     */
    List<absent>likeSearchByBuildingName(String buildingName);

    /**
     * 根据楼宿舍名称模糊查询
     * @param dormitoryName
     * @return
     */
    List<absent>likeSearchByDormitoryName(String dormitoryName);

    /**
     * 插入一条新的信息
     * @param absent
     * @return
     */
    int insertOne(absent absent);
}
