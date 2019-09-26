package com.marlabs.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marlabs.product.model.Product;
import com.marlabs.product.service.ProductService;
@WebServlet("/productdetails")
public class ProductController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hiiiiiii");
		Product product = null;
		ProductService productservice=null;
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		product = new Product();
		product.setPid(Integer.parseInt(req.getParameter("pid")));
		product.setPname(req.getParameter("pname"));
		productservice=new ProductService();
		String result=productservice.insert(product);
		
        req.setAttribute("message", result);
        req.getRequestDispatcher("/inputdata.html").forward(req, resp);
		
		pw.close();
		
		

	}

}
