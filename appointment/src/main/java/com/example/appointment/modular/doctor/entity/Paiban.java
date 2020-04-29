package com.example.appointment.modular.doctor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("paiban")
@ApiModel(value="Paiban对象", description="排班表")
public class Paiban extends Model<Paiban> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pai_id", type = IdType.AUTO)
    private Integer paiId;

    private String one;

    private String two;

    private String three;

    private String four;

    private String five;

    private String six;

    private String seven;

    private Integer doctorId;

    @ApiModelProperty(value = "医生姓名")
    @TableField(exist = false)
    private String doctorName;


    @ApiModelProperty(value = "科室名称")
    @TableField(exist = false)
    private String departmentName;

}
