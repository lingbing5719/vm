package com.ch.vm.config;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        //项目根目录
        String projectPath = System.getProperty("user.dir");
        //Java源码输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //作者
        gc.setAuthor("林乐福");

        //自定义Service接口生成的文件名
        gc.setServiceName("%sService");
        //是否打开输出目录，默认true
        gc.setOpen(false);
        //开启swagger2模式（将实体类默认的Javadoc文档注解转为Swagger文档注解），默认false
        gc.setSwagger2(true);

        //日期类型的字段使用哪个类型，默认是 java8的 日期类型，此处改为 java.util.date
        gc.setDateType(DateType.ONLY_DATE);
        //是否覆盖 已存在文件，默认 false 不覆盖
        gc.setFileOverride(false);
        //mapper.xml 是否生成 ResultMap，默认 false 不生成
        gc.setBaseResultMap(true);
        //mapper.xml 是否生成 ColumnList，默认 false 不生成
        gc.setBaseColumnList(true);

        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //数据库连接URL
        dsc.setUrl("jdbc:mysql://10.30.17.153:3306/vm?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        //数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // dsc.setDriverName("com.mysql.jdbc.Driver");
        //数据库用户名
        dsc.setUsername("root");
        //数据库密码
        dsc.setPassword("Abcd@1234");
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();

        pc.setModuleName(scanner("模块名"));
        //父包名；模块将在父包下生成
        pc.setParent("com.ch.vm");
              //  .setMapper("map");
//        pc.setController("controller.vod");
        mpg.setPackageInfo(pc);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                //to dvofo nothing
            }
        };

        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        //自定义配置会优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mappers/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        //配置策略

        StrategyConfig strategy = new StrategyConfig();
        //表名下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列名下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //Boolean类型字段是否移除is前缀（默认 false）
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        //是否开启实体类Lombok模式（默认false）
        strategy.setEntityLombokModel(false);
        //是否开启RestController风格
        strategy.setRestControllerStyle(true);
//         strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");

        //公共父类
        //strategy.setSuperControllerClass("com.example.demo.controller.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");

        //表名（数据库中存在的表）;多表传数组
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //strategy.setInclude("vm_resource_contents");
//        strategy.setInclude(new String[]{
//                "article_info","article_content","article_comment","article_comment_reply",
//                "article_archive","article_label","article_category",
//                "r_article_info_article_label","r_article_info_article_category"
//        });

        //驼峰转连字符（是否开启Controller映射连字符风格）
        strategy.setControllerMappingHyphenStyle(true);

        /**
         *设置表名前缀；
         *此表名前缀若与数据库表名前缀一致，则自动创建实体类时，实体类名匹配数据库表名下划线后面的名；
         *栗子：数据库表名为 admin_info ，当strategy.setTablePrefix("admin_")时，则实体类名为Info；
         *若不设置表名前缀，则实体类名匹配数据库表名
         */
        strategy.setTablePrefix("vm_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }
}

