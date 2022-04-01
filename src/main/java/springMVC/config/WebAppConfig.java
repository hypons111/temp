package springMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//等如 mvc-servlet <context:component-scan base-package="springMVC"/> 組態
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "springMVC")
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// 使用 multipartResolver 存取圖片
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		return cmr;
	}
	
	// 讀取 WEB-INF jsp
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");
		irvr.setOrder(6);
		return irvr;
	}

	// 使用靜態資源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
	}

	// 不用 controller 導到網頁
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 當 url 為 http://localhost:8080/SpringMvcWebProject/ 就導去 membersmain.controller
		registry.addRedirectViewController("/", "membersmain.controller");
		// 當 url 為 http://localhost:8080/SpringMvcWebProject/resourcesAction 就導去
		// staticResources
		registry.addViewController("/resourcesAction").setViewName("staticResources");
	}

}
