package pl.globinska.trivia.filter;

import pl.globinska.trivia.model.User;
import pl.globinska.trivia.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


//@WebServlet("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (httpServletRequest.getUserPrincipal()!=null && httpServletRequest.getSession().getAttribute("user")==null){
            saveUserInSession(httpServletRequest);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    private void saveUserInSession(HttpServletRequest request){
        UserService userService = new UserService();
        String username = request.getUserPrincipal().getName();
        User userByUsername = userService.getUserByUsername(username);
        request.getSession(true).setAttribute("user", userByUsername);
    }


    @Override
    public void destroy() {

    }

}
