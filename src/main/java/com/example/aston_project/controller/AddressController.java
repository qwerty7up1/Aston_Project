package com.example.aston_project.controller;

import com.example.aston_project.entity.Address;
import com.example.aston_project.service.AddressServiceImpl;
import com.google.gson.Gson;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddressController", value = "/address")
public class AddressController extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new Address("NN");
        AddressServiceImpl addressService = new AddressServiceImpl();
        String s = this.gson.toJson(addressService.getAll());

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(s);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}
