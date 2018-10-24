package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BookDao;
import Dao.UsersDao;
import Entity.Book;
import Entity.Users;
import Imp.BookDaoImpl;
import Imp.UsersDaoImpl;

public class ServletBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		BookDao bd = new BookDaoImpl();

		String dos = request.getParameter("do");
		if (dos == null || dos.equals("")) {
			dos = "index";
		}
		if (dos.equals("index")) {
			List<Book> ulist = bd.getAllBook();
			session.setAttribute("ulist", ulist);
			response.sendRedirect("bookindex.jsp");
			return;
		}
		if (dos.equals("search")) {
			String name = request.getParameter("name");
			System.out.println(name);
			List<Book> ulist = bd.findBookByName(name);
			if(ulist.isEmpty()){
				out.print("<script>alert('検索内容がない！');window.location='servletbook?do=index';</script>");
			}else{
				out.print("<script>alert('検索成功！');window.location='servletbook?do=index';</script>");
			}
			return;
		}
		if (dos.equals("return")) {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			System.out.println(name);
			Book u = new Book(id, author, author, 0);
			bd.updateBook(u);
			out.print("<script>alert('返す成功！');window.location='servletbook?do=index';</script>");
			return;
		}
		if (dos.equals("borrowbefore")) {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			Book u = bd.findBookById(id);
			session.setAttribute("editbook", u);
			response.sendRedirect("borrow.jsp");
			return;
		}
		if (dos.equals("borrow")) {
			String ids = request.getParameter("id");
			System.out.println(ids);
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			String borrowerId = request.getParameter("borrowerId");
			int borrowI = Integer.parseInt(borrowerId);
			Book b = new Book(id, name, author, borrowI);
			bd.updateBook(b);
			out.print("<script>alert('成功！');window.location='servletusers?do=index';</script>");
			return;
		}
	}
}
