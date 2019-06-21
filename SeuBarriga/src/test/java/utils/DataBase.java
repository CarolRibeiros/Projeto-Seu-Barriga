package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import readers.Config;

public class DataBase {
	
	public static List<Map<String, Object>> rows = BDtoList();

//	public static void CreateTable(String nome) throws ClassNotFoundException, SQLException {
//		Class.forName("org.h2.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\Sempre IT\\OneDrive - Sempre IT\\PROJETOS\\Seu Barriga\\SeuBarriga\\src\\test\\resources\\DataBaseH2\\BarrigaDB", "sa", "");		
//		Statement stmt = conn.createStatement(); 
//		String sql = "CREATE TABLE " + nome + " (URL varchar, "
//				+ "USER varchar(150), "
//				+ "EMAIL varchar(150), "
//				+ "SENHA varchar(150), "
//				+ "NOME varchar(150), "
//				+ "TIPO_MOVIMENTA플O varchar(150), "
//				+ "DESCRI플O varchar(150), "
//				+ "INTERESSADO varchar(150), "
//				+ "VALOR varchar(150), "
//				+ "CONTA varchar(150) );";
//		stmt.execute(sql);
//	}	
//
//	public static void InsertTable(String name) throws ClassNotFoundException, SQLException {
//		Class.forName("org.h2.Driver");
//		Connection conn = DriverManager.getConnection(
//				"jdbc:h2:file:" + Config.getProperty("path.banco"),
//				"sa", "");
//		Statement stmt = conn.createStatement();
//		String sqlInsert = "INSERT INTO " + name + " (URL, USER, EMAIL, SENHA, NOME, TIPO_MOVIMENTA플O, "
//				+ "DESCRI플O, INTERESSADO, VALOR, CONTA) "
//				+ "VALUES ('https://seubarriga.wcaquino.me/login', 'tester','tester@sempreit.com.br', "
//				+ "'tester', 'Gasolina', 'Receita', 'Testes', 'Roberto', '150', 'Gasolina');";
//		stmt.execute(sqlInsert);
//	}
//
//	public static String returnData(String table, String coluna) throws ClassNotFoundException, SQLException {
//		Class.forName("org.h2.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:h2:file:" + Config.getProperty("path.banco"), "sa", "");
//		Statement stmt = conn.createStatement();
//		String data = null;
//		ResultSet resultSet = SelectTable(stmt, table);
//		while (resultSet.next()) {
//			data = resultSet.getString("URL");
//
//		}
//
//		stmt.close();
//		conn.close();
//
//		return data;
//	}

	public static ResultSet SelectTable(Statement stmt, String name) throws ClassNotFoundException, SQLException {
		String sqlSelect = "SELECT * FROM " + name + ";";
		ResultSet resultSet = stmt.executeQuery(sqlSelect);
		return resultSet;
	}

	public static ResultSet resultSet() throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:file:" + Config.getProperty("path.banco"), "sa", "");
		Statement stmt = conn.createStatement();
		ResultSet resultSet = SelectTable(stmt, "BarrigaDB");

		return resultSet;
	}

		
	public static List<Map<String, Object>> BDtoList(){
		try {
			ResultSet rs = resultSet();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<String, Object>(columns);
				for (int i = 1; i <= columns; ++i) {
					row.put(md.getColumnName(i), rs.getObject(i));
				}
				rows.add(row);
			}
			return rows;
		} catch(Exception e){
			System.out.println(e);		
		}		
		return rows;		
	}

	public static String MapBarrigaDB(String chave) throws Exception {	
		Map<String, String> map = new HashMap<String, String>();
		for (Map<String, Object> row : rows) {
			for (Map.Entry<String, Object> rowEntry : row.entrySet()) {
				map.put(rowEntry.getKey(), (String) rowEntry.getValue());
				
			}
		}
		String dado = map.get(chave);
		return dado;
	}

//	public static void main(String[] args) throws Exception {
//	 Class.forName("org.h2.Driver");
//	 Connection conn = DriverManager.getConnection(Config.getProperty("path.banco"), "sa", "");
//	 Statement stmt = conn.createStatement();
//	
//	 CreateTable("BarrigaDB");
//	 InsertTable("BarrigaDB");
//	 ResultSet resultSet = SelectTable(stmt, "BarrigaDB");
//	 while(resultSet.next()) {
//	 System.out.println(resultSet.getString("URL"));
//     }
//	
//	 stmt.close();
//	 conn.close();

}
