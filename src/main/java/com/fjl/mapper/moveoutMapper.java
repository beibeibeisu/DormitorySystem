package com.fjl.mapper;

import com.fjl.pojo.moveout;

import java.util.List;

public interface moveoutMapper {
    /**
     * 增添一个迁出信息
     * @param moveout
     * @return
     */
    int addOne(moveout moveout);
    /**
     * 得到全部迁出学生的信息
     */
    List<moveout>getList();

    /**
     * 根据学生姓名进行模糊查询
     * @param studentName
     * @return
     */
    List<moveout>likeSearchByStudentName(String studentName);

    /**
     * 根据宿舍姓名进行模糊查询
     * @param dormitoryName
     * @return
     */
    List<moveout>likeSearchByDormitoryName(String dormitoryName);
}
