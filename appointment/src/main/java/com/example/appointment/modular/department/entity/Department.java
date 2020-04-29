package com.example.appointment.modular.department.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
@Data
@TableName("department")
@ApiModel(value="Department对象", description="部门")
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer departmentId;

    @ApiModelProperty(value = "科室名称")
    private String departmentName;

}
