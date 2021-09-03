package customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomerDAO {
	private DataSource datasource = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	public CustomerDAO() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:/comp/env");
			datasource = (DataSource)env.lookup("jdbc/oracle");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addCustomer(CustomerVO customerVO) {
		String sql = "INSERT INTO ezcustomer (num, name, tel, address) VALUES (?, ?, ?, ?)";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, customerVO.getNum());
			stmt.setString(2, customerVO.getName());
			stmt.setString(3, customerVO.getTel());
			stmt.setString(4, customerVO.getAddress());

			stmt.executeUpdate();
			stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CustomerVO> getCustomers() {
		List<CustomerVO> listCustomers = new ArrayList<CustomerVO>();
		
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM ezcustomer ORDER BY num";
			
			conn = datasource.getConnection();
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				
				CustomerVO customer = new CustomerVO();
				customer.setNum(num);
				customer.setName(name);
				customer.setTel(tel);
				customer.setAddress(address);
				
				listCustomers.add(customer);
			}
		}
		catch(SQLException e) {
			System.out.println("[getCustomers] SQLException: " + e.toString());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				
				conn.close();
			}
			catch(Exception e) {
				System.out.println("[getCustomers] finally SQLException: " + e.toString());
			}
			
			// OracleConnector.closeConnection();
			
		}	
		return listCustomers;
	}
	
	public void delCustomer(String num) {
		String sql = "DELETE FROM ezcustomer WHERE num = ?";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, num);
			stmt.executeUpdate();
			stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer(CustomerVO customerVO) {
		String sql = "UPDATE ezcustomer SET name=?, tel=?, address=? WHERE num=?";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, customerVO.getName());
			stmt.setString(2, customerVO.getTel());
			stmt.setString(3, customerVO.getAddress());
			stmt.setString(4, customerVO.getNum());

			stmt.executeUpdate();
			stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public CustomerVO getCustomer(String id) {
		String sql = "SELECT * FROM ezcustomer WHERE num=? ORDER BY num";
		ResultSet rs = null;
		CustomerVO customer = new CustomerVO();
		
		try {
			conn = datasource.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);

			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				
				customer.setNum(num);
				customer.setName(name);
				customer.setTel(tel);
				customer.setAddress(address);
			}
		}
		catch(SQLException e) {
			System.out.println("[getCustomers] SQLException: " + e.toString());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				
				conn.close();
			}
			catch(Exception e) {
				System.out.println("[getCustomers] finally SQLException: " + e.toString());
			}
		}	
		return customer;
	}
	
}
