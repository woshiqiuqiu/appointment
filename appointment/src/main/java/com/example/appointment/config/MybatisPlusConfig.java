package com.example.appointment.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author King
 */
@Configuration
@MapperScan("com.example.appointment.modular.*.dao")
public class MybatisPlusConfig {

//    /**
//     * 分页拦截器插件
//     *
//     * @return 分页拦截器
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//
//        return new PaginationInterceptor();
//    }
//    @Bean
//    public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }
//
//    @Bean
//    public ConfigurationCustomizer configurationCustomizer(){
//
//        return (configuration)->{
//            configuration.setJdbcTypeForNull(JdbcType.NULL);
//        };
//    }
}
