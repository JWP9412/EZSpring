package ebooks;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
*/

public class EBookDAO {
	static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String userid = "SHYUSER";
	static final String password = "SHYUSER";
	
//	private DataSource datasource = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	public EBookDAO() {
		System.out.println("[EBooks2]");
	
		/*
		try {
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:/comp/env");
			datasource = (DataSource)env.lookup("jdbc/oracle");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
		
		try {
			Class.forName(driver);
//			conn = DriverManager.getConnection(url, userid, password);
		}catch (ClassNotFoundException e) {
			System.out.println("[getConnection] ClassNotFoundException : "+e.toString());
			
		} catch (Exception e) {
			System.out.println("[getConnection] Exception : "+ e.toString());
		}
		
	}
		
	public void addBook(EBookVO ebookVO) {
//		String sql = "INSERT INTO ebook VALUES (EBOOK_SEQUENCE.nextval, ?, ?, ?, ?)"; // 강사님이 작성한 원본
		String sql = "INSERT INTO ebook VALUES (EB_SERIAL.nextval, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, userid, password);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ebookVO.getTitle());
			stmt.setString(2, ebookVO.getAuthor());
			stmt.setInt(3, ebookVO.getPrice());
			stmt.setInt(4, ebookVO.getQty());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				conn.close();
			} catch (SQLException e) {
				System.out.println("[getBooks] finally SQLException : " + e.toString());
			}
		}
	}
	
	public List<EBookVO> getBooks() {
		List<EBookVO> listBooks = new ArrayList<EBookVO>();
		
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM ebook ORDER BY eb_serial desc";
			
			conn = DriverManager.getConnection(url, userid, password);
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Integer serial = rs.getInt("eb_serial");
				String title   = rs.getString("eb_title");
				String author  = rs.getString("eb_author");
				Integer price  = rs.getInt("eb_price");
				Integer qty    = rs.getInt("eb_qty");
				
				EBookVO ebook = new EBookVO(serial, title, author, price, qty);
				listBooks.add(ebook);
			}
		}
		catch(SQLException e) {
			System.out.println("[getBooks] SQLException: " + e.toString());
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
				System.out.println("[getBooks] finally SQLException: " + e.toString());
			}
		}	
		return listBooks;
	}
	
	public void delBook(String serial) {
		String sql = "DELETE FROM ebook WHERE eb_serial = ?";
		
		try {
			conn = DriverManager.getConnection(url, userid, password);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(serial));
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				conn.close();
			} catch (SQLException e) {
				System.out.println("[getBooks] finally SQLException : " + e.toString());
			}
		}
	}

	public void updateBook(EBookVO ebookVO) {
		String sql = "UPDATE ebook SET eb_title=?, eb_author=?, eb_price=?, eb_qty=? WHERE eb_serial=?";
		
		try {
			conn = DriverManager.getConnection(url, userid, password);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ebookVO.getTitle());
			stmt.setString(2, ebookVO.getAuthor());
			stmt.setInt(3, ebookVO.getPrice());
			stmt.setInt(4, ebookVO.getQty());
			stmt.setInt(5, ebookVO.getSerial());

			stmt.executeUpdate();
			stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public EBookVO getBook(String no) {
		String sql = "SELECT * FROM ebook WHERE eb_serial=?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, userid, password);
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(no));

			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Integer serial = rs.getInt("eb_serial");
				String title   = rs.getString("eb_title");
				String author  = rs.getString("eb_author");
				Integer price  = rs.getInt("eb_price");
				Integer qty    = rs.getInt("eb_qty");
				
				EBookVO ebook = new EBookVO(serial, title, author, price, qty);
				return ebook;
			}
		}
		catch(SQLException e) {
			System.out.println("[getBook] SQLException: " + e.toString());
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
				System.out.println("[getBook] finally SQLException: " + e.toString());
			}
		}	
		return null;
	}
	
	public boolean isBook(Integer serial) {
		String sql = "SELECT decode(count(*),1,'true','false') AS booked FROM ebook WHERE eb_serial=?";

		boolean booked = false;
		
		try {
			conn = DriverManager.getConnection(url, userid, password);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, serial);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				booked = Boolean.parseBoolean(rs.getString("booked"));
			}
			System.out.println("booked=" + booked);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return booked;
	}	
}
