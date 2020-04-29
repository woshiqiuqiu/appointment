package com.example.appointment.modular.doctor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("doctor")
@ApiModel(value="Doctor对象", description="医生")
public class Doctor extends Model<Doctor> {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer doctorId;

    private String doctorName;

    private String doctorSex;

    @ApiModelProperty(value = "部门")
    private Integer departmentId;

    @ApiModelProperty(value = "科室名称")
    @TableField(exist = false)
    private String departmentName;

    private Integer dstate;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty( value = "电话")
    @TableField(exist = false)
    private String telphone;
}
