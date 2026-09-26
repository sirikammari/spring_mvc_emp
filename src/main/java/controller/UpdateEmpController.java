package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UpdateEmpController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int eid=Integer.parseInt(request.getParameter("eid"));
		String ename=request.getParameter("ename");
		double sal=Double.parseDouble(request.getParameter("sal"));
		String desg=request.getParameter("desg");
		List<Employee> empList=new ArrayList<Employee>();
		
		try {
			Connection con=DBConn.getConn();
			
			PreparedStatement pstmt = con.prepareStatement("update emptbl set ename=?,sal=?, desg=? where eid=?");
			pstmt.setString(1,ename);
			pstmt.setDouble(2,sal);
			pstmt.setString(3,desg);
			pstmt.setInt(4,eid);
			int i=pstmt.executeUpdate();
			System.out.println(i+" emp updated");
			
			ResultSet rs=con.createStatement().executeQuery("select * from emptbl");
			while(rs.next()) {
				Employee emp=new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				empList.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("showEmpList", "empList", empList);
	}
}
