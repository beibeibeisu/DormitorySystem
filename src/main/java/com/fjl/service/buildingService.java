package com.fjl.service;

import com.fjl.pojo.building;

import java.util.List;

public interface buildingService {
    /**
     * 查询所有楼宇的信息
     */
    List<building> findList();
    /**
     * 更新一个数据
     */
    int updateOne(building building);

    /**
     * 插入一个新的楼宇
     * @param building
     * @return
     */
    int insertOne(building building);

    /**
     * 模糊查询
     * @param key
     * @param value
     * @return
     */
    List<building> likeSearch(String key,String value);

    /**
     * 根据ID删除一个楼宇
     * @param id
     * @return
     */
    void delete(int id);

    /**
     * 根据楼管id 查询楼宇
     * @param id
     * @return
     */
    List<building>findByAdminId(int id);

    /**
     * 根据楼宇id 查询楼管id
     * @param buildingId
     * @return
     */
    Integer findOneAdminId(int buildingId);
}
