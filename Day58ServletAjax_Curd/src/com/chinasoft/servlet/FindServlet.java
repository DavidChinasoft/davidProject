package com.chinasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.dao.impl.UserDaoImpl;
import com.chinasoft.entity.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/findAll")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private UserDaoImpl userdao = new UserDaoImpl();
	private List<User> list = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResultSet rs = userdao.findAll();//查询所有的用户
		list = new ArrayList<User>();
		//将查到的用户封装到集合中
		try {
			while(rs != null && rs.next())
			{
				list.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list);
		Gson gson = new Gson();
		String goal = gson.toJson(list);
		System.out.println(goal);
		out.write(goal);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
