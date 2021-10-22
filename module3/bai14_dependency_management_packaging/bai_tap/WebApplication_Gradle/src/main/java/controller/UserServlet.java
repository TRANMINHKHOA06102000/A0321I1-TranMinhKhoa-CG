package controller;

import model.bean.User;
import model.service.user.UserService;
import model.service.user.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = {"", "/user"})
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                try {
                    createUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionUser");
        if (action == null)
            action = "";
        switch (action) {
            case "create":
                    showCreateForm(request, response);
                break;
//            case "view":
//                viewProduct(request, response);
//                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                String name=request.getParameter("searchName");
                List<User> userList=name==""?userService.selectAllUsers():userService.findUser(name);
                request.setAttribute("listUser",userList);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
        }
        loadList(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        if (user == null) {
            request.setAttribute("msg", "Can't find this user");
            loadList(request, response);
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("editName");
        String email = request.getParameter("editEmail");
        String country = request.getParameter("editCountry");
        User user = new User(id, name, email, country);
        if (userService.updateUser(user)) {
            loadList(request, response);
        } else {
            request.setAttribute("msgEdit", "Update not successfull");
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (userService.deleteUser(id)) {
            loadList(request, response);
        } else {
            request.setAttribute("msg", "Xoa ko thanh cong");
            loadList(request, response);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        userService.insertUser(user);
        loadList(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=userService.getIdAuto();
        System.out.println(id);
        request.setAttribute("idAuto",id);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", userService.selectAllUsers());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
