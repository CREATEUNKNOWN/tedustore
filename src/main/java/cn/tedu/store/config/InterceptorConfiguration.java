package cn.tedu.store.config;

import cn.tedu.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfiguration
		implements WebMvcConfigurer {

	@Override
	public void addInterceptors(
			InterceptorRegistry registry) {
		// 创建拦截器对象
		HandlerInterceptor interceptor
				= new LoginInterceptor();

		// 白名单
		List<String> list = new ArrayList<>();
		list.add("/bootstrap3/**");
		list.add("/images/**");
		list.add("/css/**");
		list.add("/js/**");

		list.add("/districts/**");

		list.add("/users/reg");
		list.add("/users/login");
		list.add("/web/register.html");
		list.add("/web/login.html");

		// 添加拦截器
		registry.addInterceptor(interceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(list);
	}

	
	
}
