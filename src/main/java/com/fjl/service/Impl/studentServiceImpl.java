package com.fjl.service.Impl;

import com.fjl.mapper.dormitoryMapper;
import com.fjl.mapper.moveoutMapper;
import com.fjl.mapper.studentMapper;
import com.fjl.pojo.dormitory;
import com.fjl.pojo.moveout;
import com.fjl.pojo.student;
import com.fjl.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class studentServiceImpl implements studentService {
    @Autowired
    private  studentMapper studentMapper;
    @Autowired
    private dormitoryMapper dormitoryMapper;
    @Autowired
    private moveoutMapper moveoutMapper;
    @Override
    public List<student> list() {
        return studentMapper.list();
    }

    @Override
    public List<dormitory> getAllAvailable() {
        return dormitoryMapper.isAvailable();
    }
    @Transactional
    @Override
    public void deleteOne(int id, int dormitoryId) {
        studentMapper.deleteOne(id);
        dormitoryMapper.updateAddAvailable(dormitoryId);
    }
    @Transactional
    @Override
    public void addOne(student student) {
        studentMapper.insertOne(student);
        dormitoryMapper.updateDeclineAvailable(student.getDormitoryId());
    }
    @Transactional
    @Override
    public void updateOne(student student, int oldDormitoryId) {
        //1.首先是更新学生的信息
        //2.老宿舍新加一个空位
        //3.新宿舍减去一个空位
        studentMapper.updateOne(student);
        if (student.getDormitoryId()!=oldDormitoryId){
            dormitoryMapper.updateAddAvailable(oldDormitoryId);
            dormitoryMapper.updateDeclineAvailable(student.getDormitoryId());
        }
    }

    @Override
    public List<student> search(String key, String value) {
        if (value.equals(""))
            return this.list();
        switch (key){
            case "number":
                return studentMapper.searchByNumber(value);
            case "name":
                return studentMapper.searchByName(value);
        }

        return null;
    }
    @Transactional
    @Override
    public void updateOneState(moveout moveout) {
        //1.修改学生的state状态
        //2.将该学生宿舍的空余床位+1
        //3.新增moveout信息
        studentMapper.updateOneState(moveout.getStudentId());
        dormitoryMapper.updateAddAvailable(moveout.getDormitoryId());
        moveoutMapper.addOne(moveout);
    }

    @Override
    public List<moveout> getAllMoveOut() {
        return moveoutMapper.getList();
    }

    @Override
    public List<moveout> moveOutLikeSearch(String key, String value) {
        if (value.equals(""))
            return this.getAllMoveOut();
        switch (key){
            case "studentName":
                return moveoutMapper.likeSearchByStudentName(value);
            case "dormitoryName":
                return moveoutMapper.likeSearchByDormitoryName(value);
        }
        return null;
    }

    @Override
    public List<student> findByDormitoryId(int dormitoryId) {
        return studentMapper.findStudentByDormitoryId02(dormitoryId);
    }
}
