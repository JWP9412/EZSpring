package ebooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;





public class EbookDAO {

	private DataSource datasource = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	public EbookDAO() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:/comp/env");
			datasource = (DataSource)env.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addBook(EbookVO ebookVO) {
		String sql = "INSERT INTO ebook VALUES (EB_SERIAL.nextval, ?, ?, ?, ?)";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ebookVO.getTitle());
			stmt.setString(2, ebookVO.getAuthor());
			stmt.setInt(3, ebookVO.getPrice());
			stmt.setInt(4, ebookVO.getQty());
			
			stmt.executeUpdate();
			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<EbookVO> getBooks(){
		List<EbookVO> listBooks = new ArrayList<EbookVO>();
		
		ResultSet rs= null;
		
		String sql = "SELECT * FROM ebook ORDER BY eb_serial desc";
		
		try {
			conn = datasource.getConnection();
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Integer serial = rs.getInt("eb_serial");
				String title = rs.getString("eb_title");
				String author = rs.getString("eb_author");
				Integer price = rs.getInt("eb_price");
				Integer qty = rs.getInt("eb_qty");
				
				EbookVO ebook = new EbookVO(serial, title, author, price, qty);
				listBooks.add(ebook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return listBooks;		
	}
	public void delBook(Integer serial) {
		String sql = "DELETE FROM ebook WHERE eb_serial=?";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, serial);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateBook(EbookVO ebookVO) {
		String sql = "UPDATE ebook SET eb_title=?, eb_author=?, eb_price=?, eb_qty=? WHERE eb_serial=?";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ebookVO.getTitle());
			stmt.setString(2, ebookVO.getAuthor());
			stmt.setInt(3, ebookVO.getPrice());
			stmt.setInt(4, ebookVO.getQty());
			stmt.setInt(5, ebookVO.getSerial());
			
			stmt.executeUpdate();
			stmt.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public EbookVO getBook(Integer no) {
		String sql = "SELECT * FROM ebook WHERE eb_serial = "+no;
		ResultSet rs = null;
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, no);
			
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				Integer serial = rs.getInt("eb_serial");
				String title = rs.getString("eb_title");
				String author = rs.getString("eb_author");
				Integer price = rs.getInt("eb_price");
				Integer qty = rs.getInt("eb_qty");
				
				EbookVO ebook = new EbookVO(serial, title , author ,price, qty);
				return ebook;
			}
		} catch (Exception e) {
			System.out.println("[EbookDAO] updateEbook : "+e.toString());
		}
		finally {
			try {
				if(rs != null) {
					System.out.println("Before rs :"+rs);
					rs.close();
					System.out.println("After rs :"+rs);
				}
				if(stmt != null) {
					stmt.close();
				}
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean isBook(Integer serial) {
		String sql = "SELECT decode(count(eb_serial),1,'true','false') AS booked FROM ebook WHERE eb_serial="+serial;
		
		boolean booked = false;
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet rs =stmt.executeQuery();
			
			if(rs.next()) {
				booked = Boolean.parseBoolean(rs.getString("booked"));
			}
			System.out.println("[isBook] booked : "+booked);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booked;
	}
	
}
