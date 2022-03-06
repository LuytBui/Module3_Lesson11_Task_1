package com.codegym.controller;

import com.codegym.model.com.codegym.Product;
import com.codegym.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "add":
                showAddNewProduct(request, response);
                break;
            case "edit":
                showEditProduct(request, response);
                break;
            case "delete":
                showDeleteProduct(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            default:
                showAllProduct(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "add":
                addNewProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "view":
                // doGet only //
                break;
            default:
                break;
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productService.findByID(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product", product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product-jsp/view-product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productService.findByID(Integer.parseInt(request.getParameter("id")));
        productService.remove(product);
        request.setAttribute("message", "Product deleted!");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product-jsp/delete-product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Product product = productService.findByID(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product", product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product-jsp/delete-product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        String description = request.getParameter("description");

        Product newProduct = new Product(id, name, price, description);
        Product oldProduct = productService.findByID(Integer.parseInt(request.getParameter("id")));

        productService.edit(oldProduct, newProduct);
        request.setAttribute("message", "Product edited!");
        request.setAttribute("oldProduct", newProduct);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product-jsp/edit-product.jsp");
        requestDispatcher.forward(request, response);

    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product oldProduct = productService.findByID(id);

        request.setAttribute("oldProduct", oldProduct);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product-jsp/edit-product.jsp");
        requestDispatcher.forward(request, response);
    }
    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        String description = request.getParameter("description");
        this.productService.add(new Product(id, name, price, description));

        request.setAttribute("message", "New product added!");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product-jsp/add-new-product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAddNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product-jsp/add-new-product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Product> products = this.productService.getList();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product-jsp/show-list.jsp");
        requestDispatcher.forward(request, response);
    }
}
