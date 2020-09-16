package com.test.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/10  16:18
 *   使用过滤器对非法登录进行拦截
 */
public class oneFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpSession session=null;
        //1 调用请求对象读取请求包中请求行中URi,了解用户访问的资源文件是谁？
        String uri =request.getRequestURI();//网站名/资源文件名   /myWeb/login   or  /myWeb/login.html
        //2 如果是登录相关的或默认欢迎文件  就放行
        if (uri.indexOf("login")!=-1||"/myWeb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //3 如果是其他文件 需要得到用户在服务端的HttpSession(登录成功才创建Session)
        session=request.getSession(false);
        if(session!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //4 拒绝请求
        request.getRequestDispatcher("login_error.html").forward(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
