package com.ryan.tsa.common.mybatisplus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.ryan.tsa.common.controller.BaseController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * mybatis-plus代码自动生成
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
public class MyAutoGenerator {

    public static void main(String[] args) {

        /**  需要修改部分 */
        // 填写代码生成的目录
        String projectPath = "E:\\idea_workspace\\TSA-assistant\\TSA-web\\TSA-web-customer";
        //开发者信息
        String author = "Ryan";
        //数据源配置
        String dbUrl = "jdbc:mysql://localhost:3306/tsa_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "root";

        //包信息
        String parentPackageName = "com.ryan.tsa";
        String moduleName = "web.customer";

        //表名
        String[] tableName = {"tsa_customer"};
        //表前缀
        String tablePrefix = "tsa_";




        /*****************   开始生成代码   **********************/
        // Step1：代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // Step2：全局配置
        GlobalConfig gc = new GlobalConfig();


        // 拼接出代码最终输出的目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 配置开发者信息（可选）
        gc.setAuthor(author);
        // 配置是否打开目录，false 为不打开（可选）
        gc.setOpen(false);
        // 实体属性 Swagger2 注解，添加 Swagger 依赖，开启 Swagger2 模式（可选）
        //gc.setSwagger2(true);
        // 重新生成文件时是否覆盖，false 表示不覆盖（可选）
        gc.setFileOverride(false);
        // 配置主键生成策略，此处为 ASSIGN_ID（可选）
        gc.setIdType(IdType.AUTO);
        // 配置日期类型，此处为 ONLY_DATE（可选）
        gc.setDateType(DateType.ONLY_DATE);
        // 默认生成的 service 会有 I 前缀
//        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // Step3：数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // Step:4：包配置
        PackageConfig pc = new PackageConfig();
        // 配置父包名（需要修改）
        pc.setParent(parentPackageName);
        // 配置模块名（需要修改）
        pc.setModuleName(moduleName);
        // 配置 entity 包名
        pc.setEntity("domain");
        // 配置 mapper 包名
        pc.setMapper("mapper");
        // 配置 service 包名
        pc.setService("service");
        // 配置 controller 包名
        pc.setController("controller");
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String xmlTtemplatePath = "/templates/mapper.xml.vm";
         String mapperTtemplatePath = "templates/mybatisplus/mapper.java.vm";
         String qoTtemplatePath = "templates/mybatisplus/qo.java.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(xmlTtemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig(mapperTtemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/java/" + pc.getParent().replace(".","/") + "/"
                        + pc.getMapper() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(qoTtemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/java/" + pc.getParent().replace(".","/")
                        + "/qo/" + tableInfo.getEntityName() + "Qo" + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 剔除存在自定义模板的模板
        templateConfig.setXml(null);
        templateConfig.setMapper(null);
        mpg.setTemplate(templateConfig);


        // Step5：策略配置（数据库表配置）
        StrategyConfig strategy = new StrategyConfig();
        // 指定表名（
        strategy.setInclude(tableName);
        // 配置数据表与实体类名之间映射的策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 配置数据表的字段与实体类的属性名之间映射的策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 是否生成实体时，生成字段注解 默认false;
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 配置 lombok 模式
        strategy.setEntityLombokModel(true);
        // 配置Controller继承父类
        strategy.setSuperControllerClass(BaseController.class);
        // 配置 rest 风格的控制器（@RestController）
        strategy.setRestControllerStyle(true);
        // 配置驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 配置表前缀，生成实体时去除表前缀
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);

        // Step6：执行代码生成操作
        mpg.execute();
    }
}
