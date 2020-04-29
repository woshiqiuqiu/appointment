package com.example.appointment.modular.patient.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
@TableName("appointment")
@ApiModel(value="Appointment对象", description="预约")
public class Appointment extends Model<Appointment> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预约id")
    @TableId(value = "appointment_id", type = IdType.AUTO)
    private Integer appointmentId;

    private String appointmentName;

    private String appointmentDepartment;

    private LocalDateTime appointmentTime;

    @ApiModelProperty(value = "0:初诊 1:复诊")
    private String appointmentType;

    @ApiModelProperty(value = "备注")
    private String appointmentRemarks;

    @ApiModelProperty(value = "病人id")
    private Integer patientId;

}
