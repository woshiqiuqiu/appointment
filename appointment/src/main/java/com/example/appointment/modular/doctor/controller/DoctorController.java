package com.example.appointment.modular.doctor.controller;


import com.example.appointment.modular.department.service.IDepartmentService;
import com.example.appointment.modular.doctor.entity.Doctor;
import com.example.appointment.modular.doctor.entity.MedicalRecord;
import com.example.appointment.modular.doctor.entity.Paiban;
import com.example.appointment.modular.doctor.service.IDoctorService;
import com.example.appointment.modular.doctor.service.IMedicalRecordService;
import com.example.appointment.modular.doctor.service.IPaibanService;
import com.example.appointment.modular.patient.entity.Appointment;
import com.example.appointment.modular.patient.entity.Patient;
import com.example.appointment.modular.patient.service.IAppointmentService;
import com.example.appointment.modular.patient.service.IPatientService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiOperation;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
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
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    private IPaibanService paibanService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IMedicalRecordService medicalRecordService;
    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private IPatientService patientService;

    /**
     * 查询周一到周日的排班
     */
    @GetMapping("/getPaiBanOneInfo")
    @ApiOperation(value = "查询周一排班信息")
    public Object one(){
        List<Paiban> one = paibanService.one();
        return one;
    }

    /**
     * 查询个人信息
     */
    @GetMapping("/getDoctorInfo")
    @ApiOperation(value = "查询个人信息")
    public List<Doctor> getUserInfo() {
        return doctorService.list();
    }

    /**
     * 修改个人信息
     */
    @PutMapping("/putDoctorInfo")
    @ApiOperation(value = "修改个人信息")
    public Boolean putUserInfo(@RequestBody Doctor doctor) {
        return doctorService.updateById(doctor);
    }

    /**
     * 查询患者预约信息
     */
    @GetMapping("/getPatientInfo")
    @ApiOperation(value = "查询患者预约信息")
    public List<Appointment> getPatientInfo() {
        return appointmentService.list();
//        return patientService.getPatientInfo(name);
    }


    /**
     * 获取电子病历信息
     */
    @PostMapping("/getMedicalRecord")
    @ApiOperation(value = "获取电子病历信息")
    public boolean getMedicalRecord(@RequestBody MedicalRecord medicalrecord){
        return medicalRecordService.save(medicalrecord);
    }

    @PostMapping("/doc")
    @ResponseBody
    @ApiOperation(value="导出电子病历", httpMethod = "POST",produces="application/json",notes = "导出用户doc")
    public String exportDoc(@RequestBody MedicalRecord medicalrecord) throws Exception {
        List<Patient> patientList = patientService.selectPatById(medicalrecord.getName());
        for(Patient patients : patientList){
            medicalrecord.setPatientId(patients.getPatientId());
        }
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassicCompatible(true);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/code");
        Template template = configuration.getTemplate("freeMark.ftl");
        medicalRecordService.save(medicalrecord);
        List<MedicalRecord> medicalRecords = medicalRecordService.selectMed();
        Map<String, Object> dataMap = new HashMap<>();
        for (MedicalRecord medicalRecordList : medicalRecords){
            dataMap.put("name",medicalRecordList.getName());
            dataMap.put("sex",medicalRecordList.getSex());
            dataMap.put("age",medicalRecordList.getAge());
            dataMap.put("chiefComplaint",medicalRecordList.getChiefComplaint());
            dataMap.put("historyOfDisease",medicalRecordList.getHistoryOfDisease());
            dataMap.put("time",medicalRecordList.getTime());
            dataMap.put("historyOfInfection",medicalRecordList.getHistoryOfDisease());
            dataMap.put("allergyHistory",medicalRecordList.getAllergyHistory());
            dataMap.put("HistoryOfPresentIllness",medicalRecordList.getHistoryOfPresentIllness());
        }
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        template.process(dataMap, writer);
        String xmlStr = stringWriter.toString();
        ByteArrayInputStream in = new ByteArrayInputStream(xmlStr.getBytes());
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(in);
        String outputFilePath = "D://upfile/病历.pdf";
        FileOutputStream os = new FileOutputStream(new File(outputFilePath));
        FOSettings foSettings = Docx4J.createFOSettings();
        foSettings.setWmlPackage(wordMLPackage);
        Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

//        File outFile = new File("Test6.doc");
//        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
//        try {
//            template.process(dataMap,out);
//            out.flush();
//            out.close();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }


        return "success";
    }
}
