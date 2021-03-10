package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author Lowic
 * @date 2021/2/28
 */
public class LoginPageController implements PageController {

    @Resource(name = "bean/UserService")
    private UserService userService;

    /**
     * 登录页面
     *
     * @param request  HTTP 请求
     * @param response HTTP 响应
     * @return 页面地址
     */
    @GET
    @Path("/login")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "login-form.jsp";
    }

    /**
     * 登录接口
     *
     * @param request  HTTP 请求
     * @param response HTTP 响应
     * @return 页面地址
     */
    @POST
    @Path("/signIn")
    public String signIn(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        User user = userService.queryUserByNameAndPassword(
                request.getParameter("email"), request.getParameter("password"));

        if (user != null) {
            return "login-success.jsp";
        } else {
            return "login-form.jsp";
        }
    }
}
