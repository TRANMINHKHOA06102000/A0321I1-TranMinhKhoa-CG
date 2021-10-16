package controller;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"","/users"})
public class UserServlet extends HttpServlet {
    private UserService userService= new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                showSearchForm(request, response);
                break;
            case "sort":
                goSort(request,response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void goSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.sortName();
        System.out.println(userList.size());
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/search.jsp").forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        if (user == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("user/edit.jsp").forward(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/create.jsp").forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = this.userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
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
                    updateUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("nameSearch");
        List<User> userList = userService.findUser(name);
        if (userList.isEmpty()) {
            request.setAttribute("msgErr", "Can't find this product");
            request.getRequestDispatcher("user/search.jsp").forward(request, response);
        } else {
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("user/result.jsp").forward(request, response);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        if (user==null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            this.userService.updateUser(user);
            request.setAttribute("message", "Edit user was created");
            request.getRequestDispatcher("user/edit.jsp").forward(request,response);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        if (newUser==null){
            request.getRequestDispatcher("error-404.jsp");
        }else{
            this.userService.insertUser(newUser);
            request.setAttribute("message", "New user was created");
            request.getRequestDispatcher("user/create.jsp").forward(request, response);
        }
    }
}
