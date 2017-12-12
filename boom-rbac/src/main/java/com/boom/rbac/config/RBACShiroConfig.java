package com.boom.rbac.config;

import com.boom.rbac.realm.RBACShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by summer on 2017/12/7.
 * ShiroFilter configure
 */
@Configuration
public class RBACShiroConfig{

    private static final Logger log = LoggerFactory.getLogger(RBACShiroConfig.class);

    /**
     * 定义ShiroFilterFactoryBean处理资源拦截
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        log.info("RBACShiroConfig.shiroFilter() method invoke");

        //1.初始化ShiroFilterFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //2.为ShiroFilterFactoryBean设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //3.配置拦截路径
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        //配置退出路径
        filterChainDefinitionMap.put("/logout","logout");

        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，
        // 一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**","authc");

        //4.设置登录页面,默认回去webapp下面寻找login.jsp页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //5.设置登录成功默认显示页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //6.设置为授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public RBACShiroRealm rBACShiroRealm() {
        return new RBACShiroRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(rBACShiroRealm());
        return securityManager;
    }
}
