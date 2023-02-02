package com.andyron.springboot.config;

import com.andyron.springboot.component.LoginHandlerInterceptor;
import com.andyron.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 使用WebMvcConfigurerAdapter可以扩展SpringMVC的功能
 *
 * @author Andy Ron
 */
//@EnableWebMvc  // 让Spring MVC的自动配置失效，全部都要自己配置。
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        // 用/andyron 替代了 /success （这个请求已经被替代）
        registry.addViewController("andyron").setViewName("success");
    }

    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean // 将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                // 静态资源已经被SpringBoot做好了资源映射，不要我们处理了
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/user/login", "/"); // 排除不需要检查的
//                super.addInterceptors(registry);

            }
        };

        return adapter;
    }

    /**
     * 让Spring MVC使用自定义的区域信息解析器（MyLocaleResolver）
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
