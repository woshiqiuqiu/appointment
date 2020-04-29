package com.example.appointment.modular.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("user")
@ApiModel(value="User对象", description="登陆用户")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "0:管理员 1:医生 2:患者")
    private String role;

    @ApiModelProperty(value = "科室id")
    private Integer departmentId;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "电话")
    private String telphone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "照片")
    private String photo;
}
