package com.example.appointment.modular.department.dao;

import com.example.appointment.modular.department.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.appointment.modular.doctor.entity.MedicalRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> selectDepById(@Param("departmentName")String departmentName);
}
