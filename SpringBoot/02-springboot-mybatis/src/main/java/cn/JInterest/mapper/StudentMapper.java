package cn.JInterest.mapper;

import cn.JInterest.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}