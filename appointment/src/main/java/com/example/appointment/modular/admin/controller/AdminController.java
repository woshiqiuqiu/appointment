package com.example.appointment.modular.admin.controller;


import com.example.appointment.modular.admin.entity.Admin;
import com.example.appointment.modular.admin.service.IAdminService;
import com.example.appointment.modular.doctor.entity.Doctor;
import com.example.appointment.modular.doctor.service.IDoctorService;
import com.example.appointment.modular.patient.entity.Patient;
import com.example.appointment.modular.patient.service.IPatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IAdminService adminService;

    /**
     * 查询医生信息
     */
    @GetMapping("/getDoctorInfo")
    @ApiOperation(value = "查询医生信息")
    public List<Doctor> getDoctorInfo(@RequestParam(required = false)String departmentName,
                                      @RequestParam(required = false)String doctorName) {
        return doctorService.selectDocInfo(departmentName,doctorName);
    }

    /**
     * 增加医生信息
     */
    @PostMapping("/saveDoctorInfo")
    @ApiOperation(value = "增加医生信息")
    public Boolean saveDoctorInfo(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    /**
     * 修改医生信息
     */
    @PutMapping("/putDoctorInfo")
    @ApiOperation(value = "修改医生信息")
    public Boolean putDoctorInfo(@RequestBody Doctor doctor) {
        return doctorService.updateById(doctor);
    }


    /**
     * 删除医生信息
     */
    @PostMapping("/removeDoctorInfo")
    @ApiOperation(value = "删除医生信息")
    public Boolean removeDoctorInfo(Integer doctorId) {
        return doctorService.removeById(doctorId);
    }





    /**
     * 查询患者信息
     */
    @GetMapping("/getPatientInfo")
    @ApiOperation(value = "查询医生信息")
    public List<Patient> getPatientInfo() {
        return patientService.list();
    }

    /**
     * 增加患者信息
     */
    @PostMapping("/savePatientInfo")
    @ApiOperation(value = "增加患者信息")
    public Boolean savePatientInfo(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    /**
     * 修改患者信息
     */
    @PutMapping("/putPatientInfo")
    @ApiOperation(value = "修改患者信息")
    public Boolean putPatientInfo(@RequestBody Patient patient) {
        return patientService.updateById(patient);
    }

    /**
     * 删除患者信息
     */
    @PostMapping("/removePatientInfo")
    @ApiOperation(value = "删除患者信息")
    public Boolean removePatientInfo(@RequestBody Map<String, String> params) {
        Integer patientId = Integer.parseInt(params.get("patientId"));
        return patientService.removeById(patientId);
    }
    /**
     * 查询个人信息
     */
    @GetMapping("/getUserInfo")
    @ApiOperation(value = "查询个人信息")
    public List<Admin> getUserInfo() {
        return adminService.list();
    }

    /**
     * 修改个人信息
     */
    @PutMapping("/putUserInfo")
    @ApiOperation(value = "修改个人信息")
    public Boolean putUserInfo(@RequestBody Admin admin) {
        return adminService.updateById(admin);
    }
}
