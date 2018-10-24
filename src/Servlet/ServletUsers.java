package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UsersDao;
import Entity.Users;
import Imp.UsersDaoImpl;

public class ServletUsers extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		UsersDao ud = new UsersDaoImpl();

		String dos = request.getParameter("do");
		if (dos == null || dos.equals("")) {
			dos = "index";
		}
		if (dos.equals("index")) {
			List<Users> ulist = ud.getAllUsers();
			session.setAttribute("ulist", ulist);
			response.sendRedirect("index.jsp");
			return;
		}
		if (dos.equals("add")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Users u = new Users(0, name, email);
			ud.addUser(u);
			out.print("<script>alert('増加成功！');window.location='servletusers?do=index';</script>");
		}
		if (dos.equals("del")) {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			ud.delUser(id);
			out.print("<script>alert('削除成功！');window.location='servletusers?do=index';</script>");
			return;
		}
		if (dos.equals("editbefore")) {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			Users u = ud.findUserById(id);
			session.setAttribute("edituser", u);
			response.sendRedirect("edit.jsp");
			return;
		}
		if (dos.equals("edit")) {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Users u = new Users(id, name, email);
			ud.updateUser(u);
			out.print("<script>alert('変更成功！');window.location='servletusers?do=index';</script>");
			return;
		}
	}
}
