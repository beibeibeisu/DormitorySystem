package com.fjl.service;

import com.fjl.pojo.dormitory;
import com.fjl.pojo.moveout;
import com.fjl.pojo.student;

import java.util.List;

public interface studentService {
    /**
     * 查询所有学生信息
     * @return
     */
    List<student>list();

    /**
     * 查询当前所有的空余宿舍
     * @return
     */
    List<dormitory>getAllAvailable();

    /**
     * 删除一个学生相关的信息
     * @param id
     * @param dormitoryId
     */
    void deleteOne(int id,int dormitoryId);

    /**
     * 添加一个学生
     * @param student
     */
    void addOne(student student);

    /**
     * 更新一个学生的信息
     * @param student
     * @param oldDormitoryId
     */
    void updateOne(student student,int oldDormitoryId);

    /**
     * 模糊查询
     * @param key
     * @param value
     * @return
     */
    List<student>search(String key,String value);

    /**
     *更新学生状态
     * @param moveout
     */
    void updateOneState(moveout moveout);

    /**
     * 得到所有迁出的学生信息
     * @return
     */
    List<moveout>getAllMoveOut();

    /**
     * 迁出学生模糊查询
     * @param key
     * @param value
     * @return
     */
    List<moveout>moveOutLikeSearch(String key,String value);

    /**
     * 根据宿舍id  查询该宿舍下 的所有学生信息
     * @param dormitoryId
     * @return
     */
    List<student>findByDormitoryId(int dormitoryId);
}
