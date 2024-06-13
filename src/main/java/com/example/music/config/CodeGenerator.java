package com.example.music.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        // 连接数据库
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/music?serverTimezone=GMT%2B8", "root", "123456")
                .globalConfig(builder ->
                        builder.author("cxlhyx") // 设置作者
                                .enableSwagger() // 开启 swagger 模式
                                .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java") // 指定输出目录
                                .commentDate("2024-5-31")   // 日期
                )
                .packageConfig(builder ->
                        builder.parent("com.example.music") // 设置父包名
                                // .moduleName("system") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, Paths.get(System.getProperty("user.dir")) + "/src/main/resources/com/example/music/mapper")) // 设置mapperXml生成路径,还可以设置其它文件生成路径，看需求更改
                )
                .strategyConfig(builder ->
                        builder.addInclude("album") // 设置需要生成的表名
                                // .addTablePrefix("t_", "c_") // 设置过滤表前缀
                                .addInclude("band")
                                .addInclude("bandmember")
                                .addInclude("company")
                                .addInclude("composer")
                                .addInclude("lyricist")
                                .addInclude("performer")
                                .addInclude("singer")
                                .addInclude("singsong")
                                .addInclude("song")
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}