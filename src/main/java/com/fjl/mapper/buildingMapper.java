package com.fjl.mapper;

import com.fjl.pojo.building;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface buildingMapper {
    /**
     * 查询所有楼宇的信息
     * @return
     */
    List<building>findList();

    /**
     * 根据楼宇id 更新一个楼宇的信息
     * @param building
     * @return
     */
    int updateOne(building building);

    /**
     * 加入一个新的楼宇信息
     * @param building
     * @return
     */
    int insertOne(building building);

    /**
     * 根据名称进行模糊查询
     * @param name
     * @return
     */
    List<building>likeSearchByName(@Param("name")String name);

    /**
     * 根据介绍进行模糊查询
     * @param introduction
     * @return
     */
    List<building>likeSearchByIntroduction(@Param("introduction")String introduction);

    /**
     * 根据楼宇id 删除一个楼宇
     * @param id
     * @return
     */
    int deleteOneBuildingById(int id);

    /**
     * 根据宿管id 查询楼宇
     * @param id
     * @return
     */
    List<building>findByAdminId(int id);

    /**
     * 根据楼宇id 查询楼管id
     * @param buildingId
     * @return
     */
    int findDormitoryAdminId(int buildingId);
}
