//package com.ch.vm.filter;
//
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.List;
//
//
///**
// *  @author: 林乐福
// *  @Date: 2020/1/20 9:44
// *  @Description:
// */
//public class JwtFilter extends GenericFilterBean {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        String jwtToken = req.getHeader("authorization");
//        //判断authorization是否为空，为null或者""的时候不解析
//        if(jwtToken!=null&&!"".equals(jwtToken)){
//            Jws<Claims> jws = Jwts.parser().setSigningKey("chenghai@2020")
//                    .parseClaimsJws(jwtToken.replace("Bearer", ""));
//            Claims claims = jws.getBody();
//            String username = claims.getSubject();//提取出当前用户名
//            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));//提取出当前用户角色
//            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
//            SecurityContextHolder.getContext().setAuthentication(token);
//        }
//
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//}