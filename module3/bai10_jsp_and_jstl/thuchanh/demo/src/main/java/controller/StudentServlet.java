package controller;

import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"","/list","/student"})
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList =new ArrayList<>();
        studentList.add(new Student(432,"Nguyen Van A","09/04/1990",1,4.0));
        studentList.add(new Student(532,"Nguyen Van B","19/04/1990",0,6.0));
        studentList.add(new Student(732,"Nguyen Van C","29/04/1990",2,9.0));
        request.setAttribute("studentListServlet",studentList);
        request.getRequestDispatcher("list_by_jstl.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
