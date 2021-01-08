package com.yinjiansystem.yinjian.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description MybatisPlus 配置类
 * @Author DT
 * @Date 2021/1/8
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisPlusConfig {

	/**
	 * mybatis-plus分页插件<br>
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
