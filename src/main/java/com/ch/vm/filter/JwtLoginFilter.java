//package com.ch.vm.filter;
//
//import com.ch.vm.entity.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// *  @author: 林乐福
// *  @Date: 2020/1/20 9:26
// *  @Description:
// */
//public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
//
//   /**
//   * @Description
//   * @Author  林乐福
//   * @Date   2020/1/20 9:27
//   * @Param
//   * @Return
//   * @Exception
//   *
//   */
//    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
//        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
//        setAuthenticationManager(authenticationManager);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException {
//        User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
//        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse resp, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();//获取登录用户的角色
//        StringBuffer as = new StringBuffer();
//        for (GrantedAuthority authority : authorities) {
//            as.append(authority.getAuthority()).append(",");
//        }
//        String jwt = Jwts.builder()
//                .claim("authorities", as)//配置用户角色
//                .setSubject(authResult.getName())//主题
//                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))//过期时间设置成一个小时
//                .signWith(SignatureAlgorithm.HS512, "chenghai@2020")//加密算法和密钥
//                .compact();
//        Map<String, String> map = new HashMap<>();
//        map.put("token", jwt);
//        map.put("msg", "登录成功");
//        resp.setContentType("application/json;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.write(new ObjectMapper().writeValueAsString(map));
//        out.flush();
//        out.close();
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException failed) throws IOException, ServletException {
//        Map<String, String> map = new HashMap<>();
//        map.put("msg", "登录失败");
//        resp.setContentType("application/json;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.write(new ObjectMapper().writeValueAsString(map));
//        out.flush();
//        out.close();
//    }
//}