package cn.itcast.shop.utils;

import java.sql.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JdbcDemo {
     String jdbcUrl="jdbc:mysql://localhost:8080/shop";
     String className="com.mysql.jdbc.Driver";
     String user="root";
     String password="123456";
     
     
     public Connection getConnection() {
    	 
    	 
    	 Connection  connection=null;
    	 try {
    		 //加载数据库驱动
    		 Class.forName(className);
    		 connection=DriverManager.getConnection(jdbcUrl,user,password);
    		
    	 }catch (Exception e) {
			System.out.println("lianjieshibai");// TODO: handle exception
		}
    	 return connection;
     }
     
     public   void closeConnection(Connection connection) {
    	 
    	 
    	 try {
    		 
    		 connection.close();
    		 System.out.println("guanbichenggong ");
			
		} catch (Exception e) {
		System.out.println("guanbishibai");
		}
     }
     
     public void insert() {
    	 String sql="insert into user (username,password,name,email,phone,addr,state,code) values('jia','223','23','1030462238@163.com','123','123','1','1')";
    	 Connection connection=getConnection();
    	 try {
			Statement statement=connection.createStatement();
			int result=statement.executeUpdate(sql);
			if(result!=0) {
				System.out.println("caozuochenggong");
			}
			statement.close();
			
		} catch (Exception e) {
			System.out.println();
		}finally {
			closeConnection(connection);
		}
    			 
    			 
    	 
    	 
     }
     
     
     public  void  delete() {
    	 
    	 
    	 String sql="delete  from user where  uid in (2,3,4)";
    	 Connection  connection=getConnection();
    	 try {
			Statement statement=connection.createStatement();
			int result =statement.executeUpdate(sql);
			if(result!=0) {
				System.out.println("caozuochengguo");
				
			}
			statement.close();
		
		} catch (Exception e) {
			System.out.println("caozuoshibai");
		}finally {
			
			closeConnection(connection);
		}
     }
     
     
     public void update() {
    	 
    	 
    	 String sql="update user set username = '123'  where UserId='5'";
    	 Connection connection=getConnection();
    	 try {
			Statement statement=connection.createStatement();
			int result =statement.executeUpdate(sql);
			if(result!=0) {
				System.out.println("capzuochenggong");
			}
		} catch (Exception e) {
			System.out.println("caozuoshibai");// TODO: handle exception
		}finally {
			closeConnection(connection);
		}
     }
     
     public void  select() {
    	 String sql="select * from user where UserId =?";
    	 Connection connection =getConnection();
    	 try {
    		 //传递sql语句
		PreparedStatement statement=connection.prepareStatement(sql);
		//设置sql语句中占位符的值
		statement.setInt(1,1);
        ResultSet resultSet=statement.executeQuery();
         while(resultSet.next()) {
        	 System.out.println("UserName" +resultSet.getString("UserName"));
        	 
        	 
         }
         resultSet.close();
         statement.close();
		} catch (Exception e) {
			System.out.println("caosuoshibai");
		}finally {
			closeConnection(connection);
		}
     }
     
}
