package com.fjl.mapper;

import java.util.List;
import com.fjl.pojo.student;
import org.apache.ibatis.annotations.Param;

public interface studentMapper {
    /**
     * 查询所有学生信息
     * @return
     */
    List<student>list();

    /**
     * 根据id 删除一个学生
     * @param id
     * @return
     */
    int deleteOne(int id);

    /**
     * 向表中插入一个学生的信息
     * @param student
     * @return
     */
    int insertOne(student student);

    /**
     * 更新一个学生的信息
     * @param student
     * @return
     */
    int updateOne(student student);

    /**
     * 根据学号模糊查询
     * @param number
     * @return
     */
    List<student>searchByNumber(@Param("number") String number);

    /**
     * 根据名字进行模糊查询
     * @param name
     * @return
     */
    List<student>searchByName(@Param("name")String name);

    /**
     * 根据宿舍id 查询所有学生的ID
     * @param dormitoryId
     * @return
     */
    List<Integer>findStudentByDormitoryId(int dormitoryId);

    /**
     * 根据宿舍id 查询所有学生的信息
     * @param dormitoryId
     * @return
     */
    List<student>findStudentByDormitoryId02(int dormitoryId);

    /**
     * 更新一个学生的宿舍信息
     * @param studentId
     * @param dormitoryId
     * @return
     */
    int updateDormitoryId(@Param("studentId") int studentId,@Param("dormitoryId") int dormitoryId);

    /**
     * 更新一个学生的状态信息
     * @param id
     * @return
     */
    int updateOneState(int id);
}
