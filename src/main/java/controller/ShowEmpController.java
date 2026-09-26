package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ShowEmpController implements Controller 
{

@Override

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
	
		List<Employee> empList = new ArrayList<>();
		
		String msg = "";
		
		try	
		{	
		//Class.forName("com.mysql.jdbc.Driver"); // or com.mysql.cj.jdbc.Driver for newer MySQL
		
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1_emp_db", "root", "");
			Connection con=DBConn.getConn();
		
			Statement stmt = con.createStatement();
		
			ResultSet rs = stmt.executeQuery("SELECT * FROM emptbl order by eid");
			
			while (rs.next())		
			{		
				int eid = rs.getInt("eid");		
				String ename = rs.getString("ename");	
				String desg = rs.getString("desg");	
				double sal = rs.getDouble("sal");
		
				empList.add(new Employee(eid, ename, desg, sal));
			}
		}	
		catch (Exception e)
		{	
			e.printStackTrace();	
			msg = "Error: " + e.getMessage();	
		}
		
		ModelAndView mv = new ModelAndView("showEmpList");
			
		mv.addObject("empList", empList);
			
		mv.addObject("msg", msg);
			
		return mv;
		
	}

}
