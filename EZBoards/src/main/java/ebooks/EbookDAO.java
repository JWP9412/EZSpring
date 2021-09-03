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
	
	public List<EbookVO> getEbooks(){
		List<EbookVO> listEbooks = new ArrayList<EbookVO>();
		
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM ebook ORDER BY eb_serial desc";
			
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Integer serial = rs.getInt("eb_serial");
				String title = rs.getString("eb_title");
				String author = rs.getString("eb_author");
				Integer price = rs.getInt("eb_price");
				Integer qty = rs.getInt("eb_qty");
				
				EbookVO ebook = new EbookVO();
				ebook.setSerial(serial);
				ebook.setTitle(title);
				ebook.setAuthor(author);
				ebook.setPrice(price);
				ebook.setQty(qty);
				
				listEbooks.add(ebook);
			}
		} catch (SQLException e) {
			System.out.println("### [getEbooks] SQLException : " + e.toString());
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
			} catch (Exception e) {
				System.out.println("[getEbooks] finally SQLException "+e.toString());
			}
		}
		return listEbooks;
	}
	
	public EbookVO getEbook(Integer intSerial){
		String sql = "SELECT * FROM ebook WHERE eb_serial=?";
		ResultSet rs = null;
		EbookVO ebook = new EbookVO();
		
		try {
			
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, intSerial);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Integer serial = rs.getInt("eb_serial");
				String title = rs.getString("eb_title");
				String author = rs.getString("eb_author");
				Integer price = rs.getInt("eb_price");
				Integer qty = rs.getInt("eb_qty");
				
				
				ebook.setSerial(serial);
				ebook.setTitle(title);
				ebook.setAuthor(author);
				ebook.setPrice(price);
				ebook.setQty(qty);
				
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
			} catch (Exception e) {
				System.out.println("[getEbooks] finally SQLException "+e.toString());
			}
		}
		return ebook;
	}
	
	public void insertEbook(EbookVO ebookVO) {
		String sql = "INSERT INTO ebook (eb_serial, eb_title, eb_author, eb_price, eb_qty) "
				+ "VALUES (eb_serial.NEXTVAL, ?, ?, ?, ?)";
		
		try {
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, ebookVO.getTitle());
			stmt.setString(2, ebookVO.getAuthor());
			stmt.setInt(3, ebookVO.getPrice());
			stmt.setInt(4, ebookVO.getQty());
			
			stmt.executeUpdate();
			stmt.close();
		} 
		catch (Exception e) {
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
	
	public void delEbook(Integer serial) {
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
	
	
}
