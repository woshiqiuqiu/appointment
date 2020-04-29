/**
 *
 */
package generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.net.URL;


/**
 * @author zhailei
 * @createdate 2018年8月30日
 * @lastupdate 2018年8月30日
 */
public class MpGenerator {
    AutoGenerator mpg = new AutoGenerator();

    String outPutPath;
    String author;
    String modular;
    String[] tables;
    String[] prefixs;
    DataSourceConfig dataSourceConfig;
    public MpGenerator(String modular,DataSourceConfig dataSourceConfig){
        this(modular,dataSourceConfig,null);
    }
    public MpGenerator(String modular,DataSourceConfig dataSourceConfig,String[] tables){
        this(modular,dataSourceConfig,tables,null);
    }
    public MpGenerator(String modular,DataSourceConfig dataSourceConfig,String[] tables,String[] prefixs){
        this(modular,dataSourceConfig,tables,prefixs,null,null);
    }
    public MpGenerator(String modular,DataSourceConfig dataSourceConfig,String[] tables,String[] prefixs,String outPutPath,String author){
        if(outPutPath != null){
            this.outPutPath = outPutPath;
        }else {
            URL resource = MpGenerator.class.getResource("/");
            File outFile = new File(resource.getPath(),"../../src/main/java");
            if(!outFile.exists()){
                outFile.mkdirs();
            }
            this.outPutPath = outFile.getPath();
        }
        if(author != null){
            this.author=author;
        }else {
            this.author = "AutoGenerator";
        }
        this.modular = modular;
        this.tables = tables;
        this.dataSourceConfig = dataSourceConfig;
        this.prefixs = prefixs;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://localhost:3306/hospital?useSSL=false");
        new MpGenerator("user",dsc,new String[] { "user"},new String[] { "qx_", "sys_" }).init().exec();

    }
    public void exec(){
        mpg.execute();
    }
    public MpGenerator init(){
        mpg.setTemplateEngine( new FreemarkerTemplateEngine());
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(this.outPutPath);
        gc.setFileOverride(false);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(this.author);
        gc.setSwagger2(true);

        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dataSourceConfig);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        if(this.prefixs != null){
            strategy.setTablePrefix(prefixs);// 此处可以修改为您的表前缀
        }
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategy.setInclude(new String[] { "SYS_USER" }); // 需要生成的表
        // strategy.setInclude(new String[] { "SYS_PERMISSION","SYS_ROLE","SYS_ROLE_PERMISSION","SYS_USER_ROLE"}); // 需要生成的表
        if(this.tables != null){
            strategy.setInclude(tables);
        }

        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("weixin.model.BaseModel");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "del", "create_date","creator","org_code" });
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        // 自定义 service 父类
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        // 自定义 service 实现类父类
        strategy.setRestControllerStyle(true);
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.appointment.test."+modular);
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setXml("dao.mapper");
        //pc.setModuleName("test");
        mpg.setPackageInfo(pc);

//         List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        TemplateConfig tc = new TemplateConfig();
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
//          tc.setController("...");
//          tc.setEntity("...");
//          tc.setMapper("...");
//          tc.setXml("...");
//          tc.setService("...");
//          tc.setServiceImpl("...");
        mpg.setTemplate(tc);
        return this;
    }

}
