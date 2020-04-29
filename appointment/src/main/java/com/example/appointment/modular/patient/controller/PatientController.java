package com.example.appointment.modular.patient.controller;

import com.example.appointment.modular.doctor.entity.MedicalRecord;
import com.example.appointment.modular.patient.entity.Appointment;
import com.example.appointment.modular.patient.entity.Patient;
import com.example.appointment.modular.patient.service.IAppointmentService;
import com.example.appointment.modular.patient.service.IPatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

/**
 * 患者操作
 * @author wangkun
 * @since 2020-03-26
 */

@RestController
@RequestMapping("/patient")
@Api(tags = "患者操作模块")
public class PatientController {

    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private IPatientService patientService;
    /**
     * 查询预约信息
     */
    @GetMapping("/getAppointmentInfo")
    @ApiOperation(value = "查询预约信息")
    public List<Appointment> getAppointmentInfo() {
        return appointmentService.list();
    }

    /**
     * 增加预约信息
     */
    @PostMapping("saveAppointmentInfo")
    @ApiOperation(value = "修改预约信息")
    public Boolean saveAppointmentInfo(@RequestBody Appointment appointment) {
        List<Patient> patientList = patientService.list();
        for(Patient patients : patientList){
            appointment.setPatientId(patients.getPatientId());
        }
        return appointmentService.save(appointment);
    }

    /**
     * 电子病历 pdf 转换
     */
    @PostMapping("/pdf")
    @ResponseBody
    @ApiOperation(value="导出电子病历", httpMethod = "POST",produces="application/json",notes = "导出患者pdf")
    public String exportPdf() throws Exception {
        WordprocessingMLPackage mlPackage = WordprocessingMLPackage.load(new File("Test6.doc"));
        Mapper fontMapper = new IdentityPlusMapper();
        // fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
        mlPackage.setFontMapper(fontMapper);
        OutputStream os = new java.io.FileOutputStream("abc.pdf");
        FOSettings foSettings = Docx4J.createFOSettings();
        foSettings.setWmlPackage(mlPackage);
        Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
        return "success";

    }

    /**
     * 查询个人信息
     */
    @GetMapping("/getPatientInfo")
    @ApiOperation(value = "查询个人信息")
    public List<Patient> getUserInfo() {
        return patientService.list();
    }

    /**
     * 修改个人信息
     */
    @PutMapping("/putPatientInfo")
    @ApiOperation(value = "修改个人信息")
    public Boolean putUserInfo(@RequestBody Patient patient) {
        return patientService.updateById(patient);
    }


}
