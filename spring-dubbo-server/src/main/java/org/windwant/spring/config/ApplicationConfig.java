package org.windwant.spring.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.*;

import javax.servlet.MultipartConfigElement;

/**
 * Created by Administrator on 2018/1/16.
 */
@Configuration
public class ApplicationConfig {

    //-----附注：自定义的验证信息位置被覆盖，直接在路径下创建默认 ValidationMessages
//    /**
//     * 验证信息 message
//     * @return
//     */
//    @Bean
//    public LocalValidatorFactoryBean localValidatorFactoryBean(){
//        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
//        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
//        ReloadableResourceBundleMessageSource rrbms = new ReloadableResourceBundleMessageSource();
//        rrbms.setBasename("classpath:/lang/messages");
//        rrbms.setUseCodeAsDefaultMessage(false);
//        rrbms.setDefaultEncoding("UTF-8");
//        localValidatorFactoryBean.setValidationMessageSource(rrbms);
//        localValidatorFactoryBean.afterPropertiesSet();
//        return localValidatorFactoryBean;
//    }

    /**
     * springboot上传文件临时目录报错
     * 解决方法：
     * 1、重启服务，重新生成目录；
     * 2、手动创建该目录；
     * 3、在启动服务的main方法中，添加以下代码，指定上传文件的目录：
     * @Bean
     * MultipartConfigElement multipartConfigElement() {
     *     MultipartConfigFactory factory =new MultipartConfigFactory(); 
     *     factory.setLocation("/data/apps/temp"); 
     *     return factory.createMultipartConfig();
     * }
     * 4、在应用的配置文件中添加以下配置，原理同3：
     * server:
     *     tomcat:
     *         basedir: /data/apps/temp
     **/
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/data/apps/temp");
        return factory.createMultipartConfig();

    }
}
