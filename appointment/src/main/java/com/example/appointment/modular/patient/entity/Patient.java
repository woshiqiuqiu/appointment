package com.example.appointment.modular.patient.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-03-22
 */
@Data
@TableName("patient")
@ApiModel(value="Patient对象", description="病人")
public class Patient extends Model<Patient> {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer patientId;

    private String name;

    private String sex;

    private Integer age;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "名族")
    private String nation;

    @ApiModelProperty(value = "职业")
    private String occupation;

    @ApiModelProperty(value = "电话")
    private String telphone;

    @ApiModelProperty(value = "入院时间")
    private LocalDateTime time;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty( value = "类型")
    @TableField(exist = false)
    private String type;
}
