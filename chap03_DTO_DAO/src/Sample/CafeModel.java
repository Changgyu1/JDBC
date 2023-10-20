package Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CafeModel {
	
	private static Connection connection;
	private static CafeModel cafeModel = null;
	private static String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "khcafe";
	private static String password = "kh1234";
	
	public static CafeModel getInstants() throws SQLException {
		
		if(cafeModel == null) {
			cafeModel = new CafeModel();
			connection = DriverManager.getConnection(dbUrl, user, password);

		}
		return cafeModel;
		
	}
	
	public boolean updateCafe(CafeDTO cafeDTO) {
		String upSql = "UPDATE menu SET price = ? WHERE mname = ?";
		
		try {
			PreparedStatement ps = connection.prepareCall(upSql);
			
			ps.setDouble(1, cafeDTO.getPrice());
			ps.setString(2, cafeDTO.getMname());
			
			int rowUpdate = ps.executeUpdate();
			connection.close();
			ps.close();
			return rowUpdate > 0;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
