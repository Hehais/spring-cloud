package com.uzengroup.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uzengroup.annotation.ExcludeComponent;

import feign.Contract;

/**
 * 该类为Feign的配置类
 * 注意： 该类不应该在主应用程序上下文的@ComponentScan中
 * @author hehai
 */
@Configuration
@ExcludeComponent
public class FeignConfiguration {

	/**
	 * 将契约改为feign原生的默认契约，这样就可以使用feign自带的注解了。
	 * @return
	 */
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
}
