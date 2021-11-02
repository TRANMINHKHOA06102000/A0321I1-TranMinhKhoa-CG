package controller;

import model.bean.Product;
import model.service.CategoryService;
import model.service.ProductService;
import model.service.impl.CategoryServiceImpl;
import model.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet",urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService= new ProductServiceImpl();
    CategoryService categoryService= new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String product_name = request.getParameter("product_name");
        Double product_price =Double.parseDouble(request.getParameter("product_price"));
        int product_quantity = Integer.parseInt(request.getParameter("product_quantity"));
        String product_color = request.getParameter("product_color");
        String product_description = request.getParameter("product_description");
        int category_id = Integer.parseInt(request.getParameter("category_id"));

        Product product = new Product(product_name,product_price,product_quantity,product_color,
                product_description,category_id);
        Map<String, String> mapMessage = productService.create(product);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("product", product);
            try {
                showFormCreate(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.setAttribute("message", "thêm thành công");
                showList(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        productService.delete(id);
        try {
            request.setAttribute("message", "xóa thành công");
            showList(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showFormCreate(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                searchContain(request, response);
                break;
            default:
                try {
                    showList(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void searchContain(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameSearch");
        String priceSearch = request.getParameter("priceSearch");
        String categorySearch = request.getParameter("categorySearch");
        String colorSearch = request.getParameter("colorSearch");
        List<Product> productList = null;
        productList=productService.findByContain(name, priceSearch, categorySearch,colorSearch);
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", categoryService.findAll());
        request.getRequestDispatcher("/product/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }
}
