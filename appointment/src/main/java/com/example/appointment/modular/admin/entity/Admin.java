package com.example.appointment.modular.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
@Data
@TableName("admin")
@ApiModel(value="Admin对象", description="管理员")
@Component
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String adminPhoto;

}
