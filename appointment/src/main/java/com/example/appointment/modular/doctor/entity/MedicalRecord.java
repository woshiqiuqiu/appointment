package com.example.appointment.modular.doctor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-04-17
 */
@Data
@TableName("medicalrecord")
@ApiModel(value="MedicalRecord对象", description="电子病历")
public class MedicalRecord extends Model<MedicalRecord> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "病历id")
    @TableId(value = "recard_id", type = IdType.AUTO)
    private Integer recardId;

    @ApiModelProperty(value = "患者id")
    private Integer patientId;

    @ApiModelProperty(value = "患者姓名")
    @TableField(exist = false)
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "入院时间")
    private String time;

    @ApiModelProperty(value = "传染史")
    @TableField("historyOfInfection")
    private String historyOfInfection;

    @ApiModelProperty(value = "过敏史")
    @TableField("allergyHistory")
    private String allergyHistory;

    @ApiModelProperty(value = "主诉")
    @TableField("chiefComplaint")
    private String chiefComplaint;

    @ApiModelProperty(value = "疾病史")
    @TableField("historyOfDisease")
    private String historyOfDisease;

    @ApiModelProperty(value = "现病史")
    @TableField("historyOfPresentIllness")
    private String historyOfPresentIllness;

    @ApiModelProperty(value = "科室id")
    private Integer departmentId;

    @ApiModelProperty(value = "科室名称")
    @TableField(exist = false)
    private String departmentName;
}
