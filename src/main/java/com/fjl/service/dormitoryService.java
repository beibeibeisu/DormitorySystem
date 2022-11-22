package com.fjl.service;

import com.fjl.pojo.dormitory;
import com.fjl.pojo.dormitoryAdmin;

import java.util.List;

public interface dormitoryService {
    /**
     *查询所有的宿管信息
     * @return
     */
    List<dormitoryAdmin>getList();

    /**
     * 根据条件进行模型搜索
     * @param key
     * @param value
     * @return
     */
    List<dormitoryAdmin>search(String key,String value);

    /**
     * 添加一个宿管
     * @param dormitoryAdmin
     * @return
     */
    int insertOne(dormitoryAdmin dormitoryAdmin);

    /**
     * 根据id删除一个宿管
     * @param id
     * @return
     */
    int deleteOne(int id);

    /**
     * 更新一个宿管的信息
     * @param dormitoryAdmin
     * @return
     */
    int updateOne(dormitoryAdmin dormitoryAdmin);

    /**
     * 查询宿舍和它楼
     * @return
     */
    List<dormitory>listAndBuildingName();

    /**
     * 插入一个新的宿舍信息
     * @param dormitory
     * @return
     */
    int insertOneDormitory(dormitory dormitory);

    /**
     * 更新一个宿舍的信息
     * @param dormitory
     * @return
     */
    int updateDormitoryMessage(dormitory dormitory);

    /**
     * 模糊查询
     * @param key
     * @param value
     * @return
     */
    List<dormitory>likeSearch(String key,String value);

    /**
     * 根据id删除一个宿舍
     * @param id
     * @return
     */
    int deleteOneDormitory(int id);

    /**
     * 根据buildingId找宿舍
     * @param buildingId
     * @return
     */
    List<dormitory>findByBuildingId(int buildingId);
}
