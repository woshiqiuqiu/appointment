package com.example.appointment.modular.department.service.impl;

import com.example.appointment.modular.department.dao.DepartmentMapper;
import com.example.appointment.modular.department.entity.Department;
import com.example.appointment.modular.department.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Override
    public List<Department> selectDepById(String departmentName) {
        return baseMapper.selectDepById(departmentName);
    }
}
