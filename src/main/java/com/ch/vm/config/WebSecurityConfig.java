package com.ch.vm.config;

import com.ch.vm.common.RespBean;
import com.ch.vm.common.UserUtils;
import com.ch.vm.filter.CustomAuthenticationFilter;
import com.ch.vm.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author: 林乐福
 * @Date: 2020/3/4 10:32
 * @Description:
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略检测的访问路径
        web.ignoring()
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/webjars/**")
                .antMatchers("/index.html")
                .antMatchers("/static/**")
                .antMatchers("/login_p")
                .antMatchers("/favicon.ico");
    }

//    /**
//    * @Description 使用form方式传递用户名密码
//    * @Author  林乐福
//    * @Date   2020/3/4 14:32
//    * @Param  [http]
//    * @Return      void
//    * @Exception
//    *
//    */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                        o.setSecurityMetadataSource(metadataSource);
//                        o.setAccessDecisionManager(urlAccessDecisionManager);
//                        return o;
//                    }
//                })
//                .and()
//                .formLogin().loginPage("/index.html").loginProcessingUrl("/login")
//                .usernameParameter("username").passwordParameter("password")
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest req,
//                                                        HttpServletResponse resp,
//                                                        AuthenticationException e) throws IOException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        RespBean respBean = null;
//                        if (e instanceof BadCredentialsException ||
//                                e instanceof UsernameNotFoundException) {
//                            respBean = RespBean.error("账户名或者密码输入错误!");
//                        } else if (e instanceof LockedException) {
//                            respBean = RespBean.error("账户被锁定，请联系管理员!");
//                        } else if (e instanceof CredentialsExpiredException) {
//                            respBean = RespBean.error("密码过期，请联系管理员!");
//                        } else if (e instanceof AccountExpiredException) {
//                            respBean = RespBean.error("账户过期，请联系管理员!");
//                        } else if (e instanceof DisabledException) {
//                            respBean = RespBean.error("账户被禁用，请联系管理员!");
//                        } else {
//                            respBean = RespBean.error("登录失败!");
//                        }
//                        resp.setStatus(401);
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = resp.getWriter();
//                        out.write(om.writeValueAsString(respBean));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest req,
//                                                        HttpServletResponse resp,
//                                                        Authentication auth) throws IOException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        RespBean respBean = RespBean.ok("登录成功!", UserUtils.getCurrentUser());
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = resp.getWriter();
//                        out.write(om.writeValueAsString(respBean));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(new LogoutSuccessHandler() {
//                    @Override
//                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        RespBean respBean = RespBean.ok("注销成功!");
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = resp.getWriter();
//                        out.write(om.writeValueAsString(respBean));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()
//                .and().csrf().disable()
//                .exceptionHandling().accessDeniedHandler(deniedHandler);
//    }

    /**
     * @Description 支持json的方式传递用户名密码
     * @Author 林乐福
     * @Date 2020/3/4 14:31
     * @Param [http]
     * @Return void
     * @Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .loginPage("/index.html") //用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .loginProcessingUrl("/login")//登录表单form中action的地址，也就是处理认证请求的路径
                .and().csrf().disable()//禁用跨站csrf攻击防御
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    //注销处理
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        RespBean respBean = RespBean.ok("注销成功!");
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        /**
         * @Description 登录成功处理
         * @Author 林乐福
         * @Date 2020/3/4 14:57
         * @Param []
         * @Return com.ch.vm.config.CustomAuthenticationFilter
         * @Exception
         *
         */
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest req,
                                                HttpServletResponse resp,
                                                Authentication auth) throws IOException {
                resp.setContentType("application/json;charset=utf-8");
                RespBean respBean = RespBean.ok("登录成功!", UserUtils.getCurrentUser());
                ObjectMapper om = new ObjectMapper();
                PrintWriter out = resp.getWriter();
                out.write(om.writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
        /**
         * @Description 登录失败处理
         * @Author 林乐福
         * @Date 2020/3/4 14:57
         * @Param []
         * @Return com.ch.vm.config.CustomAuthenticationFilter
         * @Exception
         *
         */
        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest req,
                                                HttpServletResponse resp,
                                                AuthenticationException e) throws IOException {
                resp.setContentType("application/json;charset=utf-8");
                RespBean respBean = null;
                if (e instanceof BadCredentialsException ||
                        e instanceof UsernameNotFoundException) {
                    respBean = RespBean.error("账户名或者密码输入错误!");
                } else if (e instanceof LockedException) {
                    respBean = RespBean.error("账户被锁定，请联系管理员!");
                } else if (e instanceof CredentialsExpiredException) {
                    respBean = RespBean.error("密码过期，请联系管理员!");
                } else if (e instanceof AccountExpiredException) {
                    respBean = RespBean.error("账户过期，请联系管理员!");
                } else if (e instanceof DisabledException) {
                    respBean = RespBean.error("账户被禁用，请联系管理员!");
                } else {
                    respBean = RespBean.error("登录失败!");
                }
                resp.setStatus(401);
                ObjectMapper om = new ObjectMapper();
                PrintWriter out = resp.getWriter();
                out.write(om.writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

}