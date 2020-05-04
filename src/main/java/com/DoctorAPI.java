package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Doctor;


@WebServlet("/DoctorAPI")
public class DoctorAPI extends HttpServlet {
    private static final long serialVersionUID = 1L;


    Doctor doctorObj = new Doctor();

    public DoctorAPI() {

        super();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String output = doctorObj.insertDoctor(

                request.getParameter("doctorName"),
                request.getParameter("specialization"),
                request.getParameter("doctorUsername"),
                request.getParameter("doctorPassword"));

        response.getWriter().write(output);
    }


    private static Map getParasMap(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();
        try {
            Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");

            String queryString = scanner.hasNext() ?
                    scanner.useDelimiter("\\A").next() : "";
            scanner.close();

            String[] params = queryString.split("&");
            for (String param : params) {

                String[] p = param.split("=");
                map.put(p[0], p[1]);
            }
        } catch (Exception e) {
        }
        return map;
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map paras = getParasMap(request);

        String output = doctorObj.updateDoctor(paras.get("hidDoctorIDSave").toString(),
                paras.get("doctorName").toString(),
                paras.get("specialization").toString(),
                paras.get("doctorUsername").toString(),
                paras.get("doctorPassword").toString());

        response.getWriter().write(output);

    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map paras = getParasMap(request);

        String output = doctorObj.deleteDoctor(paras.get("doctorID").toString());

        response.getWriter().write(output);
    }

}
