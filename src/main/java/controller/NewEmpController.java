package controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class NewEmpController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		String ename=request.getParameter("ename").trim();
		String desg=request.getParameter("desg").trim();
		double sal=Double.parseDouble(request.getParameter("sal").trim());
		String msg="";
		try {
			Connection con=DBConn.getConn();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select max(eid) from emptbl");
			int eid=0;
			if(rs.next()) {
				eid=rs.getInt(1);
			}
			eid++;
			PreparedStatement pstmt=con.prepareStatement("insert into emptbl values(?,?,?,?)");
			pstmt.setInt(1, eid);
			pstmt.setString(2, ename);
			pstmt.setString(3, desg);
			pstmt.setDouble(4, sal);
			int i=pstmt.executeUpdate();
			if(i==1) {
				msg="Emp inserted";
				request.getServletContext().getRequestDispatcher("/showEmp.spring").forward(request,response);
			}
			else {
				msg="ok...Emp insertion failed";
				out.println(msg);
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
			msg=ex.getMessage();
		}
		return null;
		//return new ModelAndView("EmpStatus","emp_status",msg);				
	}			
}


