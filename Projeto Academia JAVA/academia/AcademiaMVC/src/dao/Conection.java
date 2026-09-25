package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conection {
 
	public Connection getConnection() {
 
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/dbAcademia?useUnicode=true&characterEncoding=UTF-8",
					"root", "");
 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
 
	}
}
 