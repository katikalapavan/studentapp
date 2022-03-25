package com.examples.business.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {
public Connection conn;
    private Statement stmt;
    private static final String uname="root";
    private static final String password="root123";

    private static final String driver="com.mysql.jdbc.Driver";
    private static final String dburl="jdbc:mysql://localhost/student";

    public StudentDAO()
    {
      try
      {
         Class.forName(driver);
         conn=DriverManager.getConnection(dburl,uname,password);
         stmt=conn.createStatement();
      }catch(Exception e)
      {
    	  System.out.println("<StudentDAO>Exception ="+e);
      }
    }
      public ArrayList fetchStudentData()
      {
    	  ResultSet rs = null;
    	  ArrayList list = null;
    	  Student stud = null;
    	  try
    	  {
    		  rs = stmt.executeQuery("select STUDENT_ROLL_NO,STUDENT_NAME,STUDENT_GENDER,MATHS_MARS,PHYSCS_MARS,CHEMISTRY_MARKS,COMPUTER_SCIENCE_MARKS,email,city from STUDENT_MASTER");
    		  list = new ArrayList();
    		  while(rs.next())
    		  {
    			  stud = new Student();
    			  stud.setRollNo(rs.getInt("STUDENT_ROLL_NO"));
    			  stud.setName(rs.getString("STUDENT_NAME"));
    			  stud.setGender(rs.getString("STUDENT_GENDER"));
    			  stud.setMaths(rs.getInt("MATHS_MARS"));
    			  
    			  stud.setPhysics(rs.getInt("PHYSCS_MARS"));
    			  stud.setChemistry(rs.getInt("CHEMISTRY_MARKS"));
    			  stud.setCompscience(rs.getInt("COMPUTER_SCIENCE_MARKS"));
    			  stud.setEmail(rs.getString("email"));
    			  stud.setCity(rs.getString("city"));
    			  list.add(stud);
    		  }
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  System.out.println("<fetchStudentData>Exception ="+e);
    	  }
    	  return list;
      }


   

}
