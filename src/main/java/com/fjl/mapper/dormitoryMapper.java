package com.fjl.mapper;

import com.fjl.pojo.dormitory;

import java.util.List;

public interface dormitoryMapper {
    /**
     * 根据ID 查询一个宿舍的名称
     * @param dormitoryId
     * @return
     */
    String findOneById(Integer dormitoryId);

    /**
     * 查询有多余床位的宿舍
     * @return
     */
    List<dormitory>isAvailable();

    /**
     * 删除一个学生后，该学生的宿舍空位多一个
     * @param dormitoryId
     * @return
     */
    int updateAddAvailable(int dormitoryId);

    /**
     * 添加一个学生后，该学生的宿舍空位少一个
     * @param dormitoryId
     * @return
     */
    int updateDeclineAvailable(int dormitoryId);

    /**
     * 根据楼宇id查询宿舍id
     * @param buildingId
     * @return
     */
    List<Integer>findByBuildingId(int buildingId);

    /**
     * 根据楼宇id 查询宿舍信息
     * @param buildingId
     * @return
     */
    List<dormitory>findByBuildingId02(int buildingId);

    /**
     * 查询有多余床位 的宿舍Id
     * @return
     */
    List<Integer> findOneAvailable();

    /**
     * 根据宿舍id 删除一个宿舍
     * @param id
     * @return
     */
    int deleteOneByDormitoryId(int id);

    /**
     * 查询所有宿舍信息 包含楼宇的名称
     * @return
     */
    List<dormitory>listAndBuildingName();

    /**
     * 插入一个宿舍
     * @param dormitory
     * @return
     */
    int insetOneDormitory(dormitory dormitory);

    /**
     * 根据ID更新一个宿舍的信息
     * @param dormitory
     * @return
     */
    int updateOneById(dormitory dormitory);

    /**
     * 根据名字进行模糊查询
     * @param name
     * @return
     */
    List<dormitory>likeSearchByName(String name);

    /**
     * 根据电话进行模糊查询
     * @param telephone
     * @return
     */
    List<dormitory>likeSearchByTelephone(String telephone);
}
