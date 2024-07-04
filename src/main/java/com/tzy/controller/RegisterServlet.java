package com.tzy.controller;

import com.tzy.pojo.User;
import com.tzy.service.UserService;
import com.tzy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
            userService.register(user);
            request.setAttribute("message", "注册成功！");
        } catch (Exception e) {
            request.setAttribute("message", "注册失败: " + e.getMessage());
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
