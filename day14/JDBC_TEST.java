package day14;

import java.sql.*;

public class JDBC_TEST {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/august_4_2025";
     
        		String user="root";
        		String password="root";
        		try(Connection con=DriverManager.getConnection(url,user,password))
        		{
        			System.out.println("Connect to DB");
        			String insertsql="INSERT INTO students(id,name,age) VALUES(?,?,?)";
        		
        			try(PreparedStatement pstmt=con.prepareStatement(insertsql))
        			{
        				pstmt.setInt(1, 105);
        				pstmt.setString(2, "kavitaa");
        				pstmt.setInt(3, 22);
        				int rows=pstmt.executeUpdate();
        				System.out.println("Inserted:"+rows);
        			}
        			
        			catch(SQLException e)
        			{
        				e.printStackTrace();
        			}
        			
        		
        String readsql="SELECT * FROM students";
        		
        		try(Statement stmt=con.createStatement())
        				{
        					ResultSet rs=stmt.executeQuery(readsql);
        					
        					while(rs.next())
        					{
        						System.out.println("id:"+rs.getInt("id"));
        						System.out.println("name:"+rs.getString("name"));
        						System.out.println("id:"+rs.getInt("age"));
        					}
        					
        				}
        		
        		catch(SQLException e)
        		{
        			e.printStackTrace();
        		}
        		
        		String updatesql="UPDATE students SET name=? WHERE id=?";
        		
        		try(PreparedStatement pstmt1=con.prepareStatement(updatesql))
        		{
        			pstmt1.setString(1, "Pooja");
        			pstmt1.setInt(2, 101);
        			int rows=pstmt1.executeUpdate();
        			System.out.println("Updated:"+rows);
        		}
        		
        		catch(SQLException e)
        		{
        			e.printStackTrace();
        		}
        		
        		
        		
        String deletesql="DELETE FROM students WHERE id=?";
        		
        		try(PreparedStatement pstmt2=con.prepareStatement(deletesql))
        		{
        		
        			pstmt2.setInt(1, 101);
        			int rows=pstmt2.executeUpdate();
        			System.out.println("Delete:"+rows);
        		}
        		
        		catch(SQLException e)
        		{
        			e.printStackTrace();
        		}
        		
        		}
        		catch(SQLException e)
        		{
        			e.printStackTrace();
        		}
        	}
        	}